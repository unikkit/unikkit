package org.mamce.unikkit.model.staff;

import org.mamce.unikkit.model.BaseModel;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class Achievement extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Staff staff;
	private String type;
	private String description;
	private int year;
	
	/**
	 * @return the staff
	 */
	public Staff getStaff() {
		return staff;
	}
	/**
	 * @param staff the staff to set
	 */
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
