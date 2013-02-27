package org.mamce.unikkit.model.student;

import java.util.HashSet;
import java.util.Set;

import org.mamce.unikkit.model.BaseModel;

/**
 * @author Ramesh
 *
 */
public class Semester extends BaseModel {

	private int code;
	private String name;
	private Set<Subject> subjects = new HashSet<>();
	private Set<Student> students = new HashSet<>();
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
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
	 * @return the subjects
	 */
	public Set<Subject> getSubjects() {
		return subjects;
	}
	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	/**
	 * @return the students
	 */
	public Set<Student> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
