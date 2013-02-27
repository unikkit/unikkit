package org.mamce.unikkit.web.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.mamce.unikkit.model.student.Student;
import org.mamce.unikkit.student.manager.StudentManager;
import org.mamce.unikkit.web.dto.StudentDto;

/**
 * @author Ramesh
 *
 */
@ManagedBean
@RequestScoped
public class StudentCentralBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StudentDto searchCriteria;
	private StudentDto studentDetails;
	
	// Dependency Injection from Spring
	@ManagedProperty(value = MP_STUDENT_MANAGER)
	private StudentManager studentManager;
	
	public StudentCentralBean() {
		searchCriteria = new StudentDto();
	}

	/**
	 * @return the searchCriteria
	 */
	public StudentDto getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria the searchCriteria to set
	 */
	public void setSearchCriteria(StudentDto searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	/**
	 * @return the studentDetails
	 */
	public StudentDto getStudentDetails() {
		return studentDetails;
	}

	/**
	 * @param studentDetails the studentDetails to set
	 */
	public void setStudentDetails(StudentDto studentDetails) {
		this.studentDetails = studentDetails;
	}

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

	public List<Student> getStudents() {
		return studentManager.findAllStudents();
	}
	
}
