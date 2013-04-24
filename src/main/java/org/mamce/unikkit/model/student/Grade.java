package org.mamce.unikkit.model.student;

import org.mamce.unikkit.model.BaseModel;

/**
 * @author Ramesh
 *
 */
public class Grade extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student;
	private Semester semester;
	private Subject subject;
	private String grade;
	
	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * @return the semester
	 */
	public Semester getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	
	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
