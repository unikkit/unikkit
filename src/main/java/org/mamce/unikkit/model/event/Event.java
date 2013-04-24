package org.mamce.unikkit.model.event;

import java.util.Date;

import org.mamce.unikkit.common.util.UnikkUtils;
import org.mamce.unikkit.model.BaseModel;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class Event extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;
	private boolean allDay;
	private String location;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the allDay
	 */
	public boolean isAllDay() {
		return allDay;
	}
	/**
	 * @param allDay the allDay to set
	 */
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/* Not persisted. Used for display */
	public String getReadableStartDate() {
		return UnikkUtils.getReadableDateStr(startDate);
	}
	
	public String getReadableEndDate() {
		return UnikkUtils.getReadableDateStr(endDate);
	}
	
	public String getStartTime() {
		return UnikkUtils.getTimeFromDate(getStartDate());
	}
	
	public String getEndTime() {
		return UnikkUtils.getTimeFromDate(getEndDate());
	}
}
