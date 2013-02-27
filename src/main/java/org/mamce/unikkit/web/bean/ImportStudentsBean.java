package org.mamce.unikkit.web.bean;

import java.io.File;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.mamce.unikkit.exception.UnikkImporterException;
import org.mamce.unikkit.exception.UnikkResourceException;
import org.mamce.unikkit.model.student.Student;
import org.mamce.unikkit.student.manager.StudentManager;
import org.mamce.unikkit.xls.StudentImporter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@RequestScoped
public class ImportStudentsBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value=MP_STUDENT_MANAGER)
	private StudentManager studentManager;
	
	/**
	 * @return the studentManager
	 */
	public StudentManager getStudentManager() {
		return studentManager;
	}


	/**
	 * @param studentManager the studentManager to set
	 */
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}


	public void handleStudentXlsUploadEvent(FileUploadEvent event) {  
		System.out.println("Upload started");
		UploadedFile uploadedFile = event.getFile();
		StudentImporter studentImporter = new StudentImporter();
		
		try {
			File xlsxFile = studentImporter.createACopyInServer(uploadedFile);
			List<Student> students = studentImporter.importData(xlsxFile);
			// TODO: RK: Import the students in to the database
			
			if(students != null && !students.isEmpty()) {
//				for (Student student : students) {
//					System.out.println(student.getRegistrationNumber());
//				}
				studentManager.saveAllStudent(students);
			}
			System.out.println();
		} catch (UnikkImporterException | UnikkResourceException e) {
			// TODO: RK: Implement logger
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg); 
		}
		
		FacesMessage msg = new FacesMessage("Student Data Imported successfully!");
		FacesContext.getCurrentInstance().addMessage(null, msg); 
		System.out.println("Upload ended");
	}
}
