package org.mamce.unikkit.web.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.mamce.unikkit.model.student.Student;
import org.mamce.unikkit.student.manager.StudentManager;

/**
 * @author IT09B007 - Ganesh
 *
 */
@ManagedBean
@RequestScoped
public class StudentCentralBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(StudentCentralBean.class);
	
	private List<Student> filteredStudents;
	
	// Dependency Injection from Spring
	@ManagedProperty(value = MP_STUDENT_MANAGER)
	private StudentManager studentManager;
	
	/**
	 * @return the filteredStudents
	 */
	public List<Student> getFilteredStudents() {
		return filteredStudents;
	}

	/**
	 * @param filteredStudents the filteredStudents to set
	 */
	public void setFilteredStudents(List<Student> filteredStudents) {
		this.filteredStudents = filteredStudents;
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
