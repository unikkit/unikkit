package org.mamce.unikkit.model.staff;

import org.mamce.unikkit.model.BaseModel;

/**
 * @author Ramesh
 *
 */
public class Experience extends BaseModel {

	private String beginMonth;
	private String beginYear;
	private String endMonth;
	private String endYear;
	private String description;
	
	/**
	 * @return the beginMonth
	 */
	public String getBeginMonth() {
		return beginMonth;
	}
	/**
	 * @param beginMonth the beginMonth to set
	 */
	public void setBeginMonth(String beginMonth) {
		this.beginMonth = beginMonth;
	}
	/**
	 * @return the beginYear
	 */
	public String getBeginYear() {
		return beginYear;
	}
	/**
	 * @param beginYear the beginYear to set
	 */
	public void setBeginYear(String beginYear) {
		this.beginYear = beginYear;
	}
	/**
	 * @return the endMonth
	 */
	public String getEndMonth() {
		return endMonth;
	}
	/**
	 * @param endMonth the endMonth to set
	 */
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
	/**
	 * @return the endYear
	 */
	public String getEndYear() {
		return endYear;
	}
	/**
	 * @param endYear the endYear to set
	 */
	public void setEndYear(String endYear) {
		this.endYear = endYear;
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
