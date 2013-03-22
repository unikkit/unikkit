package org.mamce.unikkit.xls;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.mamce.unikkit.common.util.UnikkUtils;
import org.mamce.unikkit.exception.UnikkImporterException;
import org.mamce.unikkit.exception.UnikkResourceException;
import org.mamce.unikkit.model.student.Student;
import org.primefaces.model.UploadedFile;

/**
 * @author Ramesh
 *
 */
public class StudentImporter extends XlsImporter implements Importer<Student> {

	@Override
	public List<Student> importData(File xlsxFile) throws UnikkImporterException {
		return getStudentFromXlsxSheets(getAllXlsxSheets(xlsxFile)); 
	}

	@Override
	public List<Student> importData(String filePath) throws UnikkImporterException {
		return getStudentFromXlsxSheets(getAllXlsxSheets(filePath));
	}

	/* (non-Javadoc)
	 * @see org.mamce.unikkit.xls.Importer#createACopyInServer(org.primefaces.model.UploadedFile)
	 */
	public File createACopyInServer(UploadedFile uploadedFile) throws UnikkResourceException {
		String destination = UnikkUtils.getStudentXlsUploadArcLocation(uploadedFile.getFileName());
		return createACopyInServer(uploadedFile, destination);
	}

	private List<Student> getStudentFromXlsxSheets(List<Sheet> sheets) {
		List<Student> students = new ArrayList<>();
		Student student = null;
		if(sheets != null && !sheets.isEmpty()) {
			for (Sheet sheet : sheets) {
				if(sheet != null) {
					int i = 0;
					for (Row row : sheet) {
						student = new Student();
						if(i > 0) {
							// TODO: RK: Add all the columns here.
							Cell cell = row.getCell(StudentImportColumns.ROLL_NUMBER);
							student.setRollNumber(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.REGISTRATION_NUMBER);
							student.setRegistrationNumber(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.NAME);
							student.setName(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.GENDER);
							student.setGender(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.DOB);
							student.setDob(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.COLLEGE);
							student.setCollege(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.DEPARTMENT);
							student.setDepartment(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.DOJ);
							// TODO: RK

							cell = row.getCell(StudentImportColumns.DIPLAMO_YOP);
							//student.setBatch(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.DIPLAMO_GPA);
							student.setDiplamoGpa(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.PLUS_TWO_YOP);
							// TODO: RK

							cell = row.getCell(StudentImportColumns.PLUS_TWO_GPA);
							student.setTwelthGpa(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.SSLC_YOP);
							// TODO: RK

							cell = row.getCell(StudentImportColumns.SSLC_GPA);
							student.setTenthGpa(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.GAP_IN_ACADEMICS);
							// TODO: RK

							cell = row.getCell(StudentImportColumns.ARREARS);
							//student.setArrears(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.HISTORY_OF_ARREARS);
							//student.setArrearsHistory(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.ADDRESS1);
							student.setAddress1(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.ADDRESS2);
							student.setAddress2(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.EMAIL);
							student.setEmail(getStringValue(cell));

							cell = row.getCell(StudentImportColumns.PHONE_NUMBER);
							//student.setPhoneNumber(getStringValue(cell));

							students.add(student);
						}
						i++;
					}
				}
			}
		}

		return students;
	}
}
