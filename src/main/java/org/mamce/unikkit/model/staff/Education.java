package org.mamce.unikkit.model.staff;

import org.mamce.unikkit.model.BaseModel;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class Education extends BaseModel {

	private String stream;
	private String specialization;
	private String yearOfCompletion;
	private String description;
	/**
	 * @return the stream
	 */
	public String getStream() {
		return stream;
	}
	/**
	 * @param stream the stream to set
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}
	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}
	/**
	 * @param specialization the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	/**
	 * @return the yearOfCompletion
	 */
	public String getYearOfCompletion() {
		return yearOfCompletion;
	}
	/**
	 * @param yearOfCompletion the yearOfCompletion to set
	 */
	public void setYearOfCompletion(String yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
