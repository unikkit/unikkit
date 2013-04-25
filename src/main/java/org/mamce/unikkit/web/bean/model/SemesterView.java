package org.mamce.unikkit.web.bean.model;

import java.util.Comparator;
import java.util.List;

import org.mamce.unikkit.model.student.Grade;

public class SemesterView implements Comparable<SemesterView> {
	private String semesterId;
	private String semesterName;
	private List<Grade> grades;
	/**
	 * @return the semesterId
	 */
	public String getSemesterId() {
		return semesterId;
	}
	/**
	 * @param semesterId the semesterId to set
	 */
	public void setSemesterId(String semesterId) {
		this.semesterId = semesterId;
	}
	/**
	 * @return the semesterName
	 */
	public String getSemesterName() {
		return semesterName;
	}
	/**
	 * @param semesterName the semesterName to set
	 */
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	/**
	 * @return the grades
	 */
	public List<Grade> getGrades() {
		return grades;
	}
	/**
	 * @param grades the grades to set
	 */
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	@Override
	public int compareTo(SemesterView o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Comparator<SemesterView> semesterViewComparator = new Comparator<SemesterView>() {

		public int compare(SemesterView semester1, SemesterView semester2) {

			String sem1 = semester1.getSemesterName().toUpperCase();
			String sem2 = semester2.getSemesterName().toUpperCase();

			//ascending order
			return sem1.compareTo(sem2);

			//descending order
			//return fruitName2.compareTo(fruitName1);
		}

	};
}
