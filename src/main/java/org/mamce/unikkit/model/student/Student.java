package org.mamce.unikkit.model.student;

import java.util.Date;
import java.util.Set;

import org.mamce.unikkit.model.BaseModel;

public class Student extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String address1;
	private String address2;
	private String rollNumber;
	private String registrationNumber;
	private int batch;
	private int gapInAcademics;
	private String gender;
	private Date dob;
	private String college;
	private String department;
	private String email;
	private String city;
	private String state;
	private String country;
	private int phoneNumber;
	private String parentName;
	private int arrears;
	private int arrearsHistory;
	private int tenthYop;
	private String tenthGpa;
	private int twelthYop;
	private String twelthGpa;
	private int diplamoYop;
	private String diplamoGpa;
	private String avatar;
	private Set<Grade> grades;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the batch
	 */
	public int getBatch() {
		return batch;
	}
	/**
	 * @param batch the batch to set
	 */
	public void setBatch(int batch) {
		this.batch = batch;
	}
	
	/**
	 * @return the gapInAcademics
	 */
	public int getGapInAcademics() {
		return gapInAcademics;
	}
	/**
	 * @param gapInAcademics the gapInAcademics to set
	 */
	public void setGapInAcademics(int gapInAcademics) {
		this.gapInAcademics = gapInAcademics;
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
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
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
	public int getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
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
	public int getArrears() {
		return arrears;
	}
	/**
	 * @param arrears the arrears to set
	 */
	public void setArrears(int arrears) {
		this.arrears = arrears;
	}
	/**
	 * @return the arrearsHistory
	 */
	public int getArrearsHistory() {
		return arrearsHistory;
	}
	/**
	 * @param arrearsHistory the arrearsHistory to set
	 */
	public void setArrearsHistory(int arrearsHistory) {
		this.arrearsHistory = arrearsHistory;
	}
	
	/**
	 * @return the tenthYop
	 */
	public int getTenthYop() {
		return tenthYop;
	}
	/**
	 * @param tenthYop the tenthYop to set
	 */
	public void setTenthYop(int tenthYop) {
		this.tenthYop = tenthYop;
	}
	/**
	 * @return the tenthGpa
	 */
	public String getTenthGpa() {
		return tenthGpa;
	}
	/**
	 * @param tenthGpa the tenthGpa to set
	 */
	public void setTenthGpa(String tenthGpa) {
		this.tenthGpa = tenthGpa;
	}
	
	/**
	 * @return the twelthYop
	 */
	public int getTwelthYop() {
		return twelthYop;
	}
	/**
	 * @param twelthYop the twelthYop to set
	 */
	public void setTwelthYop(int twelthYop) {
		this.twelthYop = twelthYop;
	}
	/**
	 * @return the twelthGpa
	 */
	public String getTwelthGpa() {
		return twelthGpa;
	}
	/**
	 * @param twelthGpa the twelthGpa to set
	 */
	public void setTwelthGpa(String twelthGpa) {
		this.twelthGpa = twelthGpa;
	}
	
	/**
	 * @return the diplamoYop
	 */
	public int getDiplamoYop() {
		return diplamoYop;
	}
	/**
	 * @param diplamoYop the diplamoYop to set
	 */
	public void setDiplamoYop(int diplamoYop) {
		this.diplamoYop = diplamoYop;
	}
	/**
	 * @return the diplamoGpa
	 */
	public String getDiplamoGpa() {
		return diplamoGpa;
	}
	/**
	 * @param diplamoGpa the diplamoGpa to set
	 */
	public void setDiplamoGpa(String diplamoGpa) {
		this.diplamoGpa = diplamoGpa;
	}
	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * @return the grades
	 */
	public Set<Grade> getGrades() {
		return grades;
	}
	/**
	 * @param grades the grades to set
	 */
	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}
}
