package org.mamce.unikkit.web.dto;

import java.util.List;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class StudentDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String rollNumber;
	private String registrationNumber;
	private String yop;
	private String studentName;
	private String gender;
	private String dob;
	private String college;
	private String department;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String phoneNumber;
	private String parentName;
	private String arrears;
	private String arrearsHistory;
	private String tenthPercent;
	private String twelthPercent;
	private String diplamoPercent;
	private List<ResultDto> results;
	
	/**
	 * @return the rollNumber
	 */
	public String getRollNumber() {
		return rollNumber;
	}
	/**
	 * @param rollNumber the rollNumber to set
	 */
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	/**
	 * @return the yop
	 */
	public String getYop() {
		return yop;
	}
	/**
	 * @param yop the yop to set
	 */
	public void setYop(String yop) {
		this.yop = yop;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * @param college the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}
	/**
	 * @param parentName the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	/**
	 * @return the arrears
	 */
	public String getArrears() {
		return arrears;
	}
	/**
	 * @param arrears the arrears to set
	 */
	public void setArrears(String arrears) {
		this.arrears = arrears;
	}
	/**
	 * @return the arrearsHistory
	 */
	public String getArrearsHistory() {
		return arrearsHistory;
	}
	/**
	 * @param arrearsHistory the arrearsHistory to set
	 */
	public void setArrearsHistory(String arrearsHistory) {
		this.arrearsHistory = arrearsHistory;
	}
	/**
	 * @return the tenthPercent
	 */
	public String getTenthPercent() {
		return tenthPercent;
	}
	/**
	 * @param tenthPercent the tenthPercent to set
	 */
	public void setTenthPercent(String tenthPercent) {
		this.tenthPercent = tenthPercent;
	}
	/**
	 * @return the twelthPercent
	 */
	public String getTwelthPercent() {
		return twelthPercent;
	}
	/**
	 * @param twelthPercent the twelthPercent to set
	 */
	public void setTwelthPercent(String twelthPercent) {
		this.twelthPercent = twelthPercent;
	}
	/**
	 * @return the diplamoPercent
	 */
	public String getDiplamoPercent() {
		return diplamoPercent;
	}
	/**
	 * @param diplamoPercent the diplamoPercent to set
	 */
	public void setDiplamoPercent(String diplamoPercent) {
		this.diplamoPercent = diplamoPercent;
	}
	/**
	 * @return the results
	 */
	public List<ResultDto> getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(List<ResultDto> results) {
		this.results = results;
	}
}
