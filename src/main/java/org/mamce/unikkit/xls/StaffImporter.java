package org.mamce.unikkit.xls;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.mamce.unikkit.exception.UnikkImporterException;
import org.mamce.unikkit.exception.UnikkResourceException;
import org.mamce.unikkit.model.staff.Staff;
import org.primefaces.model.UploadedFile;

/**
 * @author Ramesh
 *
 */
public class StaffImporter extends XlsImporter implements Importer<Staff> {

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
		String destination = "/Users/Ramesh/Documents/unikkITXlsImportArchive/ARC_STAFF_DT.xlsx";
		return createACopyInServer(uploadedFile, destination);
	}

	private List<Staff> getStaffFromXlsxSheets(List<Sheet> sheets) {
		List<Staff> staffs = new ArrayList<>();
		Staff staff = null;
		int rowCount = 0;

		if(sheets != null && !sheets.isEmpty()) {
			for (Sheet sheet : sheets) {
				if(sheet != null) {
					for (Row row : sheet) {
						if(rowCount > 0) { // Skip header row.
							staff = new Staff();
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

							// RK: Add remaining columns here.

							staffs.add(staff);
						}
						
						rowCount++;
					}
				}
			}
		}

		return staffs;
	}


}
