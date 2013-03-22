package org.mamce.unikkit.model.event;

import java.util.Date;

import org.primefaces.model.DefaultScheduleEvent;

/**
 * @author Ramesh
 *
 */
public class UnikkScheduleEvent extends DefaultScheduleEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long unikkId = -1;
	private String location;
	private String description;
	
	public UnikkScheduleEvent(long unikkId, String title, Date start, Date end) {
		this.unikkId = unikkId;
		setTitle(title);
		setStartDate(start);
		setEndDate(end);
	}

	public UnikkScheduleEvent() {}
	
	/**
	 * @return the unikkId
	 */
	public long getUnikkId() {
		return unikkId;
	}

	/**
	 * @param unikkId the unikkId to set
	 */
	public void setUnikkId(long unikkId) {
		this.unikkId = unikkId;
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
