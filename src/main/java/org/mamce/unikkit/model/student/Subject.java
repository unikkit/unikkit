package org.mamce.unikkit.model.student;

import java.util.HashSet;
import java.util.Set;

import org.mamce.unikkit.model.BaseModel;
import org.mamce.unikkit.model.Department;

/**
 * @author Ramesh
 *
 */
public class Subject extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private Set<Semester> semesters = new HashSet<>();
	private Department department;
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the semesters
	 */
	public Set<Semester> getSemesters() {
		return semesters;
	}
	/**
	 * @param semesters the semesters to set
	 */
	public void setSemesters(Set<Semester> semesters) {
		this.semesters = semesters;
	}
	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
