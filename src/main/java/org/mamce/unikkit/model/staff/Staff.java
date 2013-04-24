package org.mamce.unikkit.model.staff;

import java.util.Date;
import java.util.Set;

import org.mamce.unikkit.model.BaseModel;
import org.mamce.unikkit.model.role.Role;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class Staff extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String staffId;
	private String name;
	private Date dob;
	private Date doj;
	private String department;
	private String email;
	private String designation;
	private String college;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private int phoneNumber;
	private String gender;
	private String avatar;
	private Role role;
	private Set<StaffInterest> interests;
	private Set<Publication> publications;
	private Set<Education> education;
	private Set<Experience> workExperience;
	private Set<Membership> memberships;
	private Set<Achievement> achievements;
	
	
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
	 * @return the doj
	 */
	public Date getDoj() {
		return doj;
	}
	/**
	 * @param doj the doj to set
	 */
	public void setDoj(Date doj) {
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
	public Set<Education> getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(Set<Education> education) {
		this.education = education;
	}
	/**
	 * @return the workExperience
	 */
	public Set<Experience> getWorkExperience() {
		return workExperience;
	}
	/**
	 * @param workExperience the workExperience to set
	 */
	public void setWorkExperience(Set<Experience> workExperience) {
		this.workExperience = workExperience;
	}
	
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	/**
	 * @return the interests
	 */
	public Set<StaffInterest> getInterests() {
		return interests;
	}
	/**
	 * @param interests the interests to set
	 */
	public void setInterests(Set<StaffInterest> interests) {
		this.interests = interests;
	}
	/**
	 * @return the memberships
	 */
	public Set<Membership> getMemberships() {
		return memberships;
	}
	/**
	 * @param memberships the memberships to set
	 */
	public void setMemberships(Set<Membership> memberships) {
		this.memberships = memberships;
	}
	/**
	 * @return the achievements
	 */
	public Set<Achievement> getAchievements() {
		return achievements;
	}
	/**
	 * @param achievements the achievements to set
	 */
	public void setAchievements(Set<Achievement> achievements) {
		this.achievements = achievements;
	}
	/**
	 * @return the publications
	 */
	public Set<Publication> getPublications() {
		return publications;
	}
	/**
	 * @param publications the publications to set
	 */
	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}
	
}
