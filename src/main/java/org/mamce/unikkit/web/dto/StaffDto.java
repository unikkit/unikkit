package org.mamce.unikkit.web.dto;

import java.util.List;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class StaffDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String staffId;
	private String staffName;
	private String dob;
	private String doj;
	private String department;
	private String email;
	private String designation;
	private String college;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String phoneNumber;
	private String gender;
	private List<EducationDto> education;
	private List<ExperienceDto> workExperience;
	private List<InterestDto> interests;
	private List<MembershipDto> membership;
	private List<AchivementDto> achievements;
	private List<PublicationDto> publications;
	
	/**
	 * @return the staffId
	 */
	public String getStaffId() {
		return staffId;
	}
	/**
	 * @param staffId the staffId to set
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	/**
	 * @return the staffName
	 */
	public String getStaffName() {
		return staffName;
	}
	/**
	 * @param staffName the staffName to set
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
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
	 * @return the doj
	 */
	public String getDoj() {
		return doj;
	}
	/**
	 * @param doj the doj to set
	 */
	public void setDoj(String doj) {
		this.doj = doj;
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
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
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
	 * @return the education
	 */
	public List<EducationDto> getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(List<EducationDto> education) {
		this.education = education;
	}
	
	/**
	 * @return the workExperience
	 */
	public List<ExperienceDto> getWorkExperience() {
		return workExperience;
	}
	/**
	 * @param workExperience the workExperience to set
	 */
	public void setWorkExperience(List<ExperienceDto> workExperience) {
		this.workExperience = workExperience;
	}
	/**
	 * @return the interests
	 */
	public List<InterestDto> getInterests() {
		return interests;
	}
	/**
	 * @param interests the interests to set
	 */
	public void setInterests(List<InterestDto> interests) {
		this.interests = interests;
	}
	/**
	 * @return the membership
	 */
	public List<MembershipDto> getMembership() {
		return membership;
	}
	/**
	 * @param membership the membership to set
	 */
	public void setMembership(List<MembershipDto> membership) {
		this.membership = membership;
	}
	/**
	 * @return the achievements
	 */
	public List<AchivementDto> getAchievements() {
		return achievements;
	}
	/**
	 * @param achievements the achievements to set
	 */
	public void setAchievements(List<AchivementDto> achievements) {
		this.achievements = achievements;
	}
	/**
	 * @return the publications
	 */
	public List<PublicationDto> getPublications() {
		return publications;
	}
	/**
	 * @param publications the publications to set
	 */
	public void setPublications(List<PublicationDto> publications) {
		this.publications = publications;
	}
}
