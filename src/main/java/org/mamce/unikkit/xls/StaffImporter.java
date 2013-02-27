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
		if(sheets != null && !sheets.isEmpty()) {
			for (Sheet sheet : sheets) {
				if(sheet != null) {
					for (Row row : sheet) {
						staff = new Staff();
						Cell cell = row.getCell(1);
						staff.setStaffId(getStringValue(cell));
						// TODO: RK: Add all the columns here.
						
						staffs.add(staff);
					}
				}
			}
		}
		
		return staffs;
	}
	

}
