package org.mamce.unikkit.web.dto;

import java.util.List;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class ResultDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String semester;
	private List<SubjectDto> subjects;
	
	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}
	/**
	 * @return the subjects
	 */
	public List<SubjectDto> getSubjects() {
		return subjects;
	}
	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(List<SubjectDto> subjects) {
		this.subjects = subjects;
	}
}
