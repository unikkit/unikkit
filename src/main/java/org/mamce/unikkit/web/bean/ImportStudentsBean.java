package org.mamce.unikkit.web.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.mamce.unikkit.exception.UnikkImporterException;
import org.mamce.unikkit.exception.UnikkResourceException;
import org.mamce.unikkit.img.ImageUploader;
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
	public static final Logger LOGGER = Logger.getLogger(ImportStudentsBean.class);
	
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
		LOGGER.info("Student import started...");
		UploadedFile uploadedFile = event.getFile();
		StudentImporter studentImporter = new StudentImporter();
		
		try {
			File xlsxFile = studentImporter.createACopyInServer(uploadedFile);
			List<Student> students = studentImporter.importData(xlsxFile);
			
			if(students != null && !students.isEmpty()) {
				studentManager.saveAllStudent(students);
			}
			
			ImageUploader imgUploader = new ImageUploader();
			List<Student> updateStudents = new ArrayList<>();
			
			// Upload student avatar
			for (Student student : students) {
				if(student != null && student.getAvatar() != null) {
					String uploadedPath = imgUploader.uploadStudentAvatar(student.getId(), student.getAvatar());
					student.setAvatar(uploadedPath);
					updateStudents.add(student);
				}
			}
			studentManager.saveAllStudent(updateStudents);
		} catch (UnikkImporterException | UnikkResourceException e) {
			LOGGER.error("Error while importing student data.", e);
		}
		
		FacesMessage msg = new FacesMessage("Student Data Imported successfully!");
		FacesContext.getCurrentInstance().addMessage(null, msg); 
		LOGGER.info("Imported successfully!");
	}
}
