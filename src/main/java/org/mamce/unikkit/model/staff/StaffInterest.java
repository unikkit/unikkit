package org.mamce.unikkit.model.staff;

import org.mamce.unikkit.model.BaseModel;

/**
 * @author Ramesh
 *
 */
public class StaffInterest extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Staff staff;
	private String interest;
	
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
	 * @return the interest
	 */
	public String getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}
}
