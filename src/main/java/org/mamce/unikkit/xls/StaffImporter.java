package org.mamce.unikkit.xls;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.mamce.unikkit.common.util.UnikkUtils;
import org.mamce.unikkit.exception.UnikkImporterException;
import org.mamce.unikkit.exception.UnikkResourceException;
import org.mamce.unikkit.model.staff.Achievement;
import org.mamce.unikkit.model.staff.Membership;
import org.mamce.unikkit.model.staff.Publication;
import org.mamce.unikkit.model.staff.Staff;
import org.mamce.unikkit.model.staff.StaffInterest;
import org.mamce.unikkit.staff.manager.StaffManager;
import org.primefaces.model.UploadedFile;

/**
 * @author Ramesh
 *
 */
public class StaffImporter extends XlsImporter implements Importer<Staff> {
	
	private Map<String, Map<String, Set<? extends Object>>> staffOtherDetails = new HashMap<>();
	private int sheetType = StaffImporterColumns.SHEET_TYPE_BASE_INFO;// Default: 1, Base info sheet.
	private StaffManager staffManager;
	
	public StaffImporter(StaffManager staffManager) {
		this.staffManager = staffManager;
	}
	
	/* (non-Javadoc)
	 * @see org.mamce.unikkit.xls.Importer#importData(java.io.File)
	 */
	@Override
	public List<Staff> importData(File xlsxFile) throws UnikkImporterException {
		return getStaffFromXlsxSheets(getAllXlsxSheets(xlsxFile)); 
	}

	/* (non-Javadoc)
	 * @see org.mamce.unikkit.xls.Importer#importData(java.lang.String)
	 */
	@Override
	public List<Staff> importData(String filePath) throws UnikkImporterException {
		return getStaffFromXlsxSheets(getAllXlsxSheets(filePath));
	}

	/* (non-Javadoc)
	 * @see org.mamce.unikkit.xls.Importer#createACopyInServer(org.primefaces.model.UploadedFile)
	 */
	public File createACopyInServer(UploadedFile uploadedFile) throws UnikkResourceException {
		String destination = UnikkUtils.getStaffXlsUploadArcLocation(uploadedFile.getFileName());
		return createACopyInServer(uploadedFile, destination);
	}

	private void addOtherDetails(String staffId, Map<String, Set<? extends Object>> otherDetails) {
		Map<String, Set<? extends Object>> staffOtherDetail = staffOtherDetails.get(staffId);

		if(staffOtherDetail != null) {
			staffOtherDetails.remove(staffId);
			staffOtherDetails.put(staffId, otherDetails);
		} else {
			staffOtherDetails.put(staffId, otherDetails);
		}

	}
	
	private void setSheetType(String key) {
		if(StaffImporterColumns.COL_NAME.equalsIgnoreCase(key)) {
			this.sheetType = StaffImporterColumns.SHEET_TYPE_BASE_INFO;
		} else if(StaffImporterColumns.COL_TYPE.equalsIgnoreCase(key)) {
			this.sheetType = StaffImporterColumns.SHEET_TYPE_OTHER_INFO;
		}
	}
	
	private List<Staff> getStaffFromXlsxSheets(List<Sheet> sheets) {
		List<Staff> staffs = new ArrayList<>();
		Staff staff = null;
		
		if(sheets != null && !sheets.isEmpty()) {
			for (Sheet sheet : sheets) {
				int rowCount = 0;
				if(sheet != null) {
					for (Row row : sheet) {
						
						if(rowCount == 0) {
							// Identify the sheet type from the columns header.
							Cell keyCell = row.getCell(1); // 2nd column
							String columnTile = getStringValue(keyCell);
							setSheetType(columnTile);
						}
						
						if(rowCount > 0) { // Skip header row.
							
							switch (sheetType) {
							case StaffImporterColumns.SHEET_TYPE_BASE_INFO:
								staff = new Staff();
								populateStaff(row, staff);
								staffs.add(staff);
								break;
								
							case StaffImporterColumns.SHEET_TYPE_OTHER_INFO:
								checkTypeAndAddOtherDetails(row);
								break;
							default:
								break;
							}
							
							// RK: Add remaining columns here.
							
						}
						
						rowCount++;
					}
				}
			}
		}

		if(sheetType == StaffImporterColumns.SHEET_TYPE_OTHER_INFO) {
			staffs = matchStaffs();
		}
		return staffs;
	}

	private void populateStaff(Row row, Staff staff) {
		Cell cell = row.getCell(StaffImporterColumns.STAFF_NUMBER);
		staff.setStaffId(getStringValue(cell));

		cell = row.getCell(StaffImporterColumns.NAME);
		staff.setName(getStringValue(cell));

		cell = row.getCell(StaffImporterColumns.DOJ);
		staff.setDoj(getDateValue(cell));

		cell = row.getCell(StaffImporterColumns.GENDER);
		staff.setGender(getStringValue(cell));

		cell = row.getCell(StaffImporterColumns.DOB);
		staff.setDob(getDateValue(cell));

		cell = row.getCell(StaffImporterColumns.COLLEGE);
		staff.setCollege(getStringValue(cell));
		
		cell = row.getCell(StaffImporterColumns.DESIGNATION);
		staff.setDesignation(getStringValue(cell));

		cell = row.getCell(StaffImporterColumns.DEPARTMENT);
		staff.setDepartment(getStringValue(cell));

		cell = row.getCell(StaffImporterColumns.ADDRESS1);
		staff.setAddress1(getStringValue(cell));

		cell = row.getCell(StaffImporterColumns.ADDRESS2);
		staff.setAddress2(getStringValue(cell));

		cell = row.getCell(StaffImporterColumns.EMAIL);
		staff.setEmail(getStringValue(cell));

		cell = row.getCell(StaffImporterColumns.CITY);
		staff.setCity(getStringValue(cell));

		cell = row.getCell(StaffImporterColumns.STATE);
		staff.setState(getStringValue(cell));

		cell = row.getCell(StaffImporterColumns.COUNTRY);
		staff.setCountry(getStringValue(cell));
		
		cell = row.getCell(StaffImporterColumns.AVATAR_PATH);
		staff.setAvatar(getStringValue(cell));
	}
	
	private void checkTypeAndAddOtherDetails(Row row) {
		Cell cellType = row.getCell(StaffImporterColumns.OTHER_TYPE);
		String type = getStringValue(cellType);
		
		if(StaffImporterColumns.OTHER_DETAILS_TYPE_INTEREST.equalsIgnoreCase(type)) {
			// Create Staff Interest object
			StaffInterest interest = new StaffInterest();
			Cell cell = row.getCell(StaffImporterColumns.OTHER_INT);
			interest.setInterest(getStringValue(cell));
			
			cell = row.getCell(StaffImporterColumns.OTHER_STAFF_NUMBER);
			String staffId = getStringValue(cell);
			
			addInterestToTheQueue(staffId, interest);
			
		} else if(StaffImporterColumns.OTHER_DETAILS_TYPE_PUB.equalsIgnoreCase(type)) {
			// Create Staff publication object
			Publication pub = new Publication();
			Cell cell = row.getCell(StaffImporterColumns.OTHER_PUB_TYPE);
			pub.setType(getStringValue(cell));
			
			cell = row.getCell(StaffImporterColumns.OTHER_PUB_DESC);
			pub.setDescription(getStringValue(cell));
			
			cell = row.getCell(StaffImporterColumns.OTHER_PUB_YEAR);
			//pub.setYear(getStringValue(cell)); // TODO: Add column in table
			
			cell = row.getCell(StaffImporterColumns.OTHER_STAFF_NUMBER);
			String staffId = getStringValue(cell);
			
			addPublicationToTheQueue(staffId, pub);
			
		} else if(StaffImporterColumns.OTHER_DETAILS_TYPE_ACHV.equalsIgnoreCase(type)) {
			// Create Staff publication object
			Achievement achv = new Achievement();
			Cell cell = row.getCell(StaffImporterColumns.OTHER_ACHV_TYPE);
			achv.setType(getStringValue(cell));

			cell = row.getCell(StaffImporterColumns.OTHER_ACHV_DESC);
			achv.setDescription(getStringValue(cell));

			cell = row.getCell(StaffImporterColumns.OTHER_ACHV_YEAR);
			achv.setYear(getIntValue(cell)); // TODO: Add column in table

			cell = row.getCell(StaffImporterColumns.OTHER_STAFF_NUMBER);
			String staffId = getStringValue(cell);

			addAchievementToTheQueue(staffId, achv);
			
		} else if(StaffImporterColumns.OTHER_DETAILS_TYPE_MEM.equalsIgnoreCase(type)) {
			// Create Staff membership object
			Membership mem = new Membership();
			Cell cell = row.getCell(StaffImporterColumns.OTHER_MEM_TYPE);
			mem.setType(getStringValue(cell));

			cell = row.getCell(StaffImporterColumns.OTHER_MEM_DESC);
			mem.setDescription(getStringValue(cell));

			cell = row.getCell(StaffImporterColumns.OTHER_MEM_YEAR);
			mem.setYear(getIntValue(cell)); // TODO: Add column in table

			cell = row.getCell(StaffImporterColumns.OTHER_STAFF_NUMBER);
			String staffId = getStringValue(cell);
			
			addMembershipToTheQueue(staffId, mem);
			
		} else if(StaffImporterColumns.OTHER_DETAILS_TYPE_WRK.equalsIgnoreCase(type)) {
			// Create Staff work experience object
			
			
		} 
	}
	
	private void addInterestToTheQueue(String staffId, StaffInterest interest) {
		addUp(staffId, StaffImporterColumns.OTHER_DETAILS_TYPE_INTEREST, interest);
	}
	
	private void addPublicationToTheQueue(String staffId, Publication pub) {
		addUp(staffId, StaffImporterColumns.OTHER_DETAILS_TYPE_PUB, pub);
	}
	
	private void addAchievementToTheQueue(String staffId, Achievement achv) {
		addUp(staffId, StaffImporterColumns.OTHER_DETAILS_TYPE_ACHV, achv);
	}

	private void addMembershipToTheQueue(String staffId, Membership mem) {
		addUp(staffId, StaffImporterColumns.OTHER_DETAILS_TYPE_MEM, mem);
	}
	
	private List<Staff> matchStaffs() {
		List<Staff> addedOtherDetails = new ArrayList<>();
		if(staffOtherDetails != null) {
			System.out.println(staffOtherDetails.keySet());
			List<Staff> existingStaffs = staffManager.findStaffs(staffOtherDetails.keySet());
			
			if(existingStaffs != null) {
				for (Staff staff : existingStaffs) {
					if(staff != null) {
						setStaffOtherDetails(staff);
						addedOtherDetails.add(staff);
					}
				}
				
			}
		}
		return addedOtherDetails;
	}
	
	private void setStaffOtherDetails(Staff staff) {
		Map<String, Set<? extends Object>> staffsOtherDetails = staffOtherDetails.get(staff.getStaffId());
		if(staffsOtherDetails != null) {
			Set<Entry<String, Set<? extends Object>>> entries = staffsOtherDetails.entrySet();
			
			for (Entry<String, Set<? extends Object>> entry : entries) {
				String key = entry.getKey();
				
				if(StaffImporterColumns.OTHER_DETAILS_TYPE_INTEREST.equalsIgnoreCase(key)) {
					Set<StaffInterest> newInterests = (Set<StaffInterest>) entry.getValue();
					
					if(staff.getInterests() == null) {
						staff.setInterests(new HashSet<StaffInterest>());
					}
					
					for (StaffInterest staffInterest : newInterests) {
						staffInterest.setStaff(staff);
					}
					
					staff.getInterests().addAll(newInterests);
				} else if(StaffImporterColumns.OTHER_DETAILS_TYPE_PUB.equalsIgnoreCase(key)) {
					Set<Publication> newPub = (Set<Publication>) entry.getValue();
					
					if(staff.getPublications() == null) {
						staff.setPublications(new HashSet<Publication>());
					}
					
					for (Publication pub : newPub) {
						pub.setStaff(staff);
					}
					
					staff.getPublications().addAll(newPub);
				} else if(StaffImporterColumns.OTHER_DETAILS_TYPE_ACHV.equalsIgnoreCase(key)) {
					Set<Achievement> newAchievement = (Set<Achievement>) entry.getValue();
					
					if(staff.getAchievements() == null) {
						staff.setAchievements(new HashSet<Achievement>());
					}
					
					for (Achievement achv : newAchievement) {
						achv.setStaff(staff);
					}
					
					staff.getAchievements().addAll(newAchievement);
				} else if(StaffImporterColumns.OTHER_DETAILS_TYPE_MEM.equalsIgnoreCase(key)) {
					Set<Membership> newMembership = (Set<Membership>) entry.getValue();
					
					if(staff.getMemberships() == null) {
						staff.setMemberships(new HashSet<Membership>());
					}
					
					for (Membership mem : newMembership) {
						mem.setStaff(staff);
					}
					
					staff.getMemberships().addAll(newMembership);
				} else if(StaffImporterColumns.OTHER_DETAILS_TYPE_WRK.equalsIgnoreCase(key)) {
					
				}
			}
		}
	}
	
	private void addUp(String staffId, String type, Object obj) {
		Map<String, Set<? extends Object>> staffOtherInfos = staffOtherDetails.get(staffId);
		
		if(null == staffOtherInfos) {
			staffOtherInfos = getDefaultMapOfData();
		}
		Set<Object> collection = (Set<Object>) staffOtherInfos.get(type);
		
		if(collection == null) {
			collection = new HashSet<>();
		}
		collection.add(obj);
		
		//staffOtherInfos.remove(type);
		//staffOtherInfos.put(type, collection);
		
		addOtherDetails(staffId, staffOtherInfos);
	}
	
	private Map<String, Set<? extends Object>> getDefaultMapOfData() {
		Map<String, Set<? extends Object>> defaultMap = new HashMap<>();
		
		defaultMap.put(StaffImporterColumns.OTHER_DETAILS_TYPE_INTEREST, new HashSet<StaffInterest>());
		defaultMap.put(StaffImporterColumns.OTHER_DETAILS_TYPE_PUB, new HashSet<Publication>());
		defaultMap.put(StaffImporterColumns.OTHER_DETAILS_TYPE_ACHV, new HashSet<Achievement>());
		defaultMap.put(StaffImporterColumns.OTHER_DETAILS_TYPE_MEM, new HashSet<Membership>());
		//defaultMap.put(StaffImporterColumns.OTHER_DETAILS_TYPE_WRK, new ArrayList<WorkExperience>());
		
		return defaultMap;
	}
}
