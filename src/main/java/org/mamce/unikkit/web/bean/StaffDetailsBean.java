package org.mamce.unikkit.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.mamce.unikkit.common.util.Constants;
import org.mamce.unikkit.common.util.FacesUtils;
import org.mamce.unikkit.common.util.UnikkUtils;
import org.mamce.unikkit.model.staff.Achievement;
import org.mamce.unikkit.model.staff.Membership;
import org.mamce.unikkit.model.staff.Publication;
import org.mamce.unikkit.model.staff.Staff;
import org.mamce.unikkit.model.staff.StaffInterest;
import org.mamce.unikkit.model.user.User;
import org.mamce.unikkit.role.manager.RoleManager;
import org.mamce.unikkit.staff.manager.StaffManager;
import org.mamce.unikkit.user.manager.UserManager;
import org.primefaces.event.RowEditEvent;

/**
 * @author Ramesh
 *
 */
@ManagedBean
@ApplicationScoped
public class StaffDetailsBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(StaffDetailsBean.class);
	
	@ManagedProperty(value=MP_STAFF_MANAGER)
	private StaffManager staffManager;
	
	@ManagedProperty(value=MP_ROLE_MANAGER)
	private RoleManager roleManager;
	
	@ManagedProperty(value=MP_USER_MANAGER)
	private UserManager userManager;
	
	private Staff selectedStaff;
	
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
	private String newInterest;
	private String newPublicationDesc;
	private String newPublicationType;
	private String newAchievementDesc;
	private String newAchievementType;
	private String newMembershipDesc;
	private String newMembershipType;
	private String roleId;
	private boolean createLogonAccount;
	
	private StaffInterest selectedInterest;
	private Publication selectedPublication;
	private Achievement selectedAchievement;
	private Membership selectedMembership;
	
	private List<StaffInterest> interests = new ArrayList<>();
	private List<Publication> publications = new ArrayList<>();
	private List<Achievement> achievements = new ArrayList<>();
	private List<Membership> memberships = new ArrayList<>();
	
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
	 * @return the newInterest
	 */
	public String getNewInterest() {
		return newInterest;
	}

	/**
	 * @param newInterest the newInterest to set
	 */
	public void setNewInterest(String newInterest) {
		this.newInterest = newInterest;
	}

	/**
	 * @return the newPublicationDesc
	 */
	public String getNewPublicationDesc() {
		return newPublicationDesc;
	}

	/**
	 * @param newPublicationDesc the newPublicationDesc to set
	 */
	public void setNewPublicationDesc(String newPublicationDesc) {
		this.newPublicationDesc = newPublicationDesc;
	}

	/**
	 * @return the newPublicationType
	 */
	public String getNewPublicationType() {
		return newPublicationType;
	}

	/**
	 * @param newPublicationType the newPublicationType to set
	 */
	public void setNewPublicationType(String newPublicationType) {
		this.newPublicationType = newPublicationType;
	}

	/**
	 * @return the newAchievementDesc
	 */
	public String getNewAchievementDesc() {
		return newAchievementDesc;
	}

	/**
	 * @param newAchievementDesc the newAchievementDesc to set
	 */
	public void setNewAchievementDesc(String newAchievementDesc) {
		this.newAchievementDesc = newAchievementDesc;
	}

	/**
	 * @return the newAchievementType
	 */
	public String getNewAchievementType() {
		return newAchievementType;
	}

	/**
	 * @param newAchievementType the newAchievementType to set
	 */
	public void setNewAchievementType(String newAchievementType) {
		this.newAchievementType = newAchievementType;
	}

	/**
	 * @return the newMembershipDesc
	 */
	public String getNewMembershipDesc() {
		return newMembershipDesc;
	}

	/**
	 * @param newMembershipDesc the newMembershipDesc to set
	 */
	public void setNewMembershipDesc(String newMembershipDesc) {
		this.newMembershipDesc = newMembershipDesc;
	}

	/**
	 * @return the newMembershipType
	 */
	public String getNewMembershipType() {
		return newMembershipType;
	}

	/**
	 * @param newMembershipType the newMembershipType to set
	 */
	public void setNewMembershipType(String newMembershipType) {
		this.newMembershipType = newMembershipType;
	}

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the createLogonAccount
	 */
	public boolean isCreateLogonAccount() {
		return createLogonAccount;
	}

	/**
	 * @param createLogonAccount the createLogonAccount to set
	 */
	public void setCreateLogonAccount(boolean createLogonAccount) {
		this.createLogonAccount = createLogonAccount;
	}

	/**
	 * @return the selectedInterest
	 */
	public StaffInterest getSelectedInterest() {
		return selectedInterest;
	}

	/**
	 * @param selectedInterest the selectedInterest to set
	 */
	public void setSelectedInterest(StaffInterest selectedInterest) {
		this.selectedInterest = selectedInterest;
	}

	/**
	 * @return the selectedPublication
	 */
	public Publication getSelectedPublication() {
		return selectedPublication;
	}

	/**
	 * @param selectedPublication the selectedPublication to set
	 */
	public void setSelectedPublication(Publication selectedPublication) {
		this.selectedPublication = selectedPublication;
	}

	/**
	 * @return the selectedAchievement
	 */
	public Achievement getSelectedAchievement() {
		return selectedAchievement;
	}

	/**
	 * @param selectedAchievement the selectedAchievement to set
	 */
	public void setSelectedAchievement(Achievement selectedAchievement) {
		this.selectedAchievement = selectedAchievement;
	}

	/**
	 * @return the selectedMembership
	 */
	public Membership getSelectedMembership() {
		return selectedMembership;
	}

	/**
	 * @param selectedMembership the selectedMembership to set
	 */
	public void setSelectedMembership(Membership selectedMembership) {
		this.selectedMembership = selectedMembership;
	}

	/**
	 * @return the interests
	 */
	public List<StaffInterest> getInterests() {
		return interests;
	}

	/**
	 * @param interests the interests to set
	 */
	public void setInterests(List<StaffInterest> interests) {
		this.interests = interests;
	}

	/**
	 * @return the publications
	 */
	public List<Publication> getPublications() {
		return publications;
	}

	/**
	 * @param publications the publications to set
	 */
	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	/**
	 * @return the achievements
	 */
	public List<Achievement> getAchievements() {
		return achievements;
	}

	/**
	 * @param achievements the achievements to set
	 */
	public void setAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
	}

	/**
	 * @return the memberships
	 */
	public List<Membership> getMemberships() {
		return memberships;
	}

	/**
	 * @param memberships the memberships to set
	 */
	public void setMemberships(List<Membership> memberships) {
		this.memberships = memberships;
	}

	/**
	 * @return the staffManager
	 */
	public StaffManager getStaffManager() {
		return staffManager;
	}

	/**
	 * @param staffManager the staffManager to set
	 */
	public void setStaffManager(StaffManager staffManager) {
		this.staffManager = staffManager;
	}

	/**
	 * @return the roleManager
	 */
	public RoleManager getRoleManager() {
		return roleManager;
	}

	/**
	 * @param roleManager the roleManager to set
	 */
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	/**
	 * @return the userManager
	 */
	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * @param userManager the userManager to set
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * @return the selectedStaff
	 */
	public Staff getSelectedStaff() {
		return selectedStaff;
	}

	/**
	 * @param selectedStaff the selectedStaff to set
	 */
	public void setSelectedStaff(Staff selectedStaff) {
		this.selectedStaff = selectedStaff;
	}
	
	public String staffDetails() {
		if(selectedStaff == null) {
			// TODO: RK: Add error message here
			
			return "staffDetails";
		}
		populateForm(selectedStaff);
		return "staffDetails";
	}
	
	public String cancelStaffDetails() {
		return "staffCentral";
	}
	
	public String addNewStaff() {
		setId(Constants.UNSAVED_ID);
		clearForm();
		return "staffDetails";
	}
	
	/**
	 * 
	 */
	public void saveStaffDetails() {
		Staff staff = null;
		try {

			if(getId() < 0) {
				staff = new Staff();
				int sequence = staffManager.findTotalStaffByDepartment(getDepartment());
				setStaffId(UnikkUtils.generateStaffNumber(getDepartment(), sequence));
				staff.setStaffId(getStaffId());
			} else {
				staff = staffManager.findStaffById(getId());

				if(staff == null) {
					FacesUtils.addErrorMessage("Staff Information not found. Could not update.");
					return;
				}
			}
			populateModel(staff);
			
			if(StringUtils.isNotBlank(roleId)) {
				staff.setRole(roleManager.findRoleById(Long.valueOf(roleId)));
			} else {
				staff.setRole(null);
			}
			
			
			staffManager.saveStaff(staff);
			populateForm(staff);
			FacesUtils.addInfoMessage("Staff information saved successfully!");
		} catch (Exception e) {
			LOGGER.error("Staff information saved successfully!", e);
			FacesUtils.addFatalMessage("Error while saving staff details");
		}
		
		
		try {
			if(isCreateLogonAccount() && StringUtils.isNotBlank(staff.getStaffId())) {
				User userAccount = userManager.findUser(staff.getStaffId());
				
				if(userAccount == null) {
					userAccount = new User();
					userAccount.setUsername(staff.getStaffId());
					userAccount.setPassword(UnikkUtils.hashIt("unikkit"));
					userAccount.setRole(staff.getRole());
					userAccount.setActive(true);
					
					userManager.saveUser(userAccount);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error while creating user logon account", e);
		}
	}
	
	/**
	 * 
	 */
	public void addNewInterest() {
		Staff staff = staffManager.findStaffById(getId());
		if(staff == null) {
			FacesUtils.addErrorMessage("Staff details could not be found.");
			LOGGER.error("Staff details could not be found.");
			return;
		}
		
		StaffInterest interest = new StaffInterest();
		interest.setInterest(newInterest);
		interest.setStaff(staff);
		
		Set<StaffInterest> interests = staff.getInterests();
		
		if(interests == null) {
			interests = new HashSet<>();
		}
		
		interests.add(interest);
		staffManager.saveStaff(staff);
		
		refreshInterests(staff.getInterests());
		setNewInterest("");
		LOGGER.info("Staff interest added!");
		FacesUtils.addInfoMessage("Staff interest added!");
	}
	
	/**
	 * 
	 */
	public void deleteInterest() {
		if(selectedInterest != null) {
			Staff staff = staffManager.findStaffById(getId());
			if(staff == null) {
				FacesUtils.addErrorMessage("Staff details could not be found.");
				LOGGER.error("Staff details could not be found.");
				return;
			}
			
			Set<StaffInterest> interests = staff.getInterests();
			
			interests.remove(selectedInterest);
			staff.setInterests(interests);
			
			staffManager.saveStaff(staff);
			
			refreshInterests(staff.getInterests());
			setSelectedInterest(null);
			
			LOGGER.info("Staff interest deleted!");
			FacesUtils.addInfoMessage("Staff interest deleted!");
		}
	}
	
	/**
	 * @param event
	 */
	public void onInterestRowEdit(RowEditEvent event) {
		StaffInterest interestEdit = (StaffInterest) event.getObject();
		
		if(interestEdit != null) {
			Staff staff = staffManager.findStaffById(getId());
			if(staff == null) {
				LOGGER.error("Staff details could not be found.");
				FacesUtils.addErrorMessage("Staff details could not be found.");
				return;
			}

			Set<StaffInterest> interests = staff.getInterests();
			
			if(interests != null) {
				interests.remove(interestEdit);
				interests.add(interestEdit);

				staff.setInterests(interests);
				staffManager.saveStaff(staff);

				refreshInterests(staff.getInterests());
				LOGGER.info("Staff interest updated!");
				FacesUtils.addInfoMessage("Staff interest updated!");
			}
		}
	}
	
	/**
	 * @param event
	 */
	public void onInterestRowEditCancel(RowEditEvent event) {
		// RK: Do nothing... :)
	}

	/**
	 * 
	 */
	public void addNewPublication() {
		Staff staff = staffManager.findStaffById(getId());
		if(staff == null) {
			LOGGER.error("Staff details could not be found.");
			FacesUtils.addErrorMessage("Staff details could not be found.");
			return;
		}
		
		Publication publication = new Publication();
		publication.setDescription(newPublicationDesc);
		publication.setType(newPublicationType);
		publication.setStaff(staff);
		
		Set<Publication> publications = staff.getPublications();
		
		if(publications == null) {
			publications = new HashSet<>();
		}
		
		publications.add(publication);
		staffManager.saveStaff(staff);
		
		refreshPublications(staff.getPublications());
		setNewPublicationDesc("");
		setNewPublicationType("");
		
		LOGGER.info("Staff publication added!");
		FacesUtils.addInfoMessage("Staff publication added!");
	}
	
	/**
	 * 
	 */
	public void deletePublication() {
		if(selectedPublication != null) {
			Staff staff = staffManager.findStaffById(getId());
			if(staff == null) {
				LOGGER.error("Staff details could not be found.");
				FacesUtils.addErrorMessage("Staff details could not be found.");
				return;
			}
			
			Set<Publication> publications = staff.getPublications();
			
			if(publications != null) {
				publications.remove(selectedPublication);
				staff.setPublications(publications);

				staffManager.saveStaff(staff);

				refreshPublications(staff.getPublications());
				setSelectedInterest(null);
				LOGGER.info("Staff publication deleted!");
				FacesUtils.addInfoMessage("Staff publication deleted!");
			}
		}
	
	}
	
	/**
	 * @param event
	 */
	public void onPublicationsRowEdit(RowEditEvent event) {
		Publication editedPublication = (Publication) event.getObject();
		
		if(editedPublication != null) {
			Staff staff = staffManager.findStaffById(getId());
			if(staff == null) {
				LOGGER.error("Staff details could not be found.");
				FacesUtils.addErrorMessage("Staff details could not be found.");
				return;
			}

			Set<Publication> publications = staff.getPublications();
			
			if(publications != null) {
				publications.remove(editedPublication);
				publications.add(editedPublication);

				staff.setPublications(publications);
				staffManager.saveStaff(staff);

				refreshPublications(staff.getPublications());
				LOGGER.info("Staff publication updated!");
				FacesUtils.addInfoMessage("Staff publication updated!");
			}
		}
	}
	
	/**
	 * @param event
	 */
	public void onPublicationsRowEditCancel(RowEditEvent event) {
		// RK: Do nothing... :)
	}
	
	/**
	 * 
	 */
	public void addNewAchievement() {
		Staff staff = staffManager.findStaffById(getId());
		if(staff == null) {
			LOGGER.error("Staff details could not be found.");
			FacesUtils.addErrorMessage("Staff details could not be found.");
			return;
		}
		
		Achievement achievement = new Achievement();
		achievement.setDescription(newAchievementDesc);
		achievement.setType(newAchievementType);
		achievement.setStaff(staff);
		
		Set<Achievement> achievements = staff.getAchievements();
		
		if(achievements == null) {
			achievements = new HashSet<>();
		}
		
		achievements.add(achievement);
		staffManager.saveStaff(staff);
		
		refreshAchievements(staff.getAchievements());
		setNewAchievementDesc("");
		setNewAchievementType("");
		
		LOGGER.info("Staff achievement added!");
		FacesUtils.addInfoMessage("Staff achievement added!");
	}
	
	/**
	 * 
	 */
	public void deleteAchievement() {
		if(selectedAchievement != null) {
			Staff staff = staffManager.findStaffById(getId());
			if(staff == null) {
				LOGGER.error("Staff details could not be found.");
				FacesUtils.addErrorMessage("Staff details could not be found.");
				return;
			}
			
			Set<Achievement> achievements = staff.getAchievements();
			
			if(achievements != null) {
				achievements.remove(selectedAchievement);
				staff.setAchievements(achievements);

				staffManager.saveStaff(staff);

				refreshAchievements(staff.getAchievements());
				setSelectedAchievement(null);
				LOGGER.info("Staff achievement deleted!");
				FacesUtils.addInfoMessage("Staff achievement deleted!");
			}
		}
	
	}
	
	/**
	 * @param event
	 */
	public void onAchievementsRowEdit(RowEditEvent event) {
		Achievement editedAchievement = (Achievement) event.getObject();
		
		if(editedAchievement != null) {
			Staff staff = staffManager.findStaffById(getId());
			if(staff == null) {
				LOGGER.error("Staff details could not be found.");
				FacesUtils.addErrorMessage("Staff details could not be found.");
				return;
			}

			Set<Achievement> achievements = staff.getAchievements();
			
			if(achievements != null) {
				achievements.remove(editedAchievement);
				achievements.add(editedAchievement);

				staff.setAchievements(achievements);
				staffManager.saveStaff(staff);

				refreshAchievements(staff.getAchievements());
				LOGGER.info("Staff achievement updated!");
				FacesUtils.addInfoMessage("Staff achievement updated!");
			}
		}
	}
	
	/**
	 * @param event
	 */
	public void onAchievementsRowEditCancel(RowEditEvent event) {
		// RK: Do nothing... :)
	}
	
	/**
	 * 
	 */
	public void addNewMembership() {
		Staff staff = staffManager.findStaffById(getId());
		if(staff == null) {
			LOGGER.error("Staff details could not be found.");
			FacesUtils.addErrorMessage("Staff details could not be found.");
			return;
		}
		
		Membership membership = new Membership();
		membership.setDescription(newMembershipDesc);
		membership.setType(newMembershipType);
		membership.setStaff(staff);
		
		Set<Membership> memberships = staff.getMemberships();
		
		if(memberships == null) {
			memberships = new HashSet<>();
		}
		
		memberships.add(membership);
		staffManager.saveStaff(staff);
		
		refreshMemberships(staff.getMemberships());
		setNewMembershipDesc("");
		setNewMembershipType("");
		
		LOGGER.info("Staff membership added!");
		FacesUtils.addInfoMessage("Staff membership added!");
	}
	
	/**
	 * 
	 */
	public void deleteMembership() {
		if(selectedMembership != null) {
			Staff staff = staffManager.findStaffById(getId());
			if(staff == null) {
				LOGGER.error("Staff details could not be found.");
				FacesUtils.addErrorMessage("Staff details could not be found.");
				return;
			}
			
			Set<Membership> memberships = staff.getMemberships();
			
			if(memberships != null) {
				memberships.remove(selectedMembership);
				staff.setMemberships(memberships);

				staffManager.saveStaff(staff);

				refreshMemberships(staff.getMemberships());
				setSelectedMembership(null);
				LOGGER.info("Staff membership deleted!");
				FacesUtils.addInfoMessage("Staff membership deleted!");
			}
		}
	
	}
	
	/**
	 * @param event
	 */
	public void onMembershipsRowEdit(RowEditEvent event) {
		Membership editedMembership = (Membership) event.getObject();
		
		if(editedMembership != null) {
			Staff staff = staffManager.findStaffById(getId());
			if(staff == null) {
				LOGGER.error("Staff details could not be found.");
				FacesUtils.addErrorMessage("Staff details could not be found.");
				return;
			}

			Set<Membership> memberships = staff.getMemberships();
			
			if(memberships != null) {
				memberships.remove(editedMembership);
				memberships.add(editedMembership);

				staff.setMemberships(memberships);
				staffManager.saveStaff(staff);

				refreshMemberships(staff.getMemberships());
				LOGGER.info("Staff membership updated!");
				FacesUtils.addInfoMessage("Staff membership updated!");
			}
		}
	}
	
	/**
	 * @param event
	 */
	public void onMembershipsRowEditCancel(RowEditEvent event) {
		// RK: Do nothing... :)
	}
	
	private void refreshInterests(Set<StaffInterest> interests) {
		if(interests != null) {
			getInterests().clear();
			getInterests().addAll(interests);
		}
	}
	
	private void refreshPublications(Set<Publication> publications) {
		if(publications != null) {
			getPublications().clear();
			getPublications().addAll(publications);
		}
	}
	private void refreshAchievements(Set<Achievement> achievements) {
		if(achievements != null) {
			getAchievements().clear();
			getAchievements().addAll(achievements);
		}
	}
	private void refreshMemberships(Set<Membership> memberships) {
		if(memberships != null) {
			getMemberships().clear();
			getMemberships().addAll(memberships);
		}
	}
	
	private void populateForm(Staff staff) {
		setId(staff.getId());
		setAddress1(staff.getAddress1());
		setAddress2(staff.getAddress2());
		setCity(staff.getCity());
		setCollege(staff.getCollege());
		setCountry(staff.getCountry());
		setDepartment(staff.getDepartment());
		setDesignation(staff.getDesignation());
		setDob(staff.getDob());
		setDoj(staff.getDoj());
		setEmail(staff.getEmail());
		setGender(staff.getGender());
		setName(staff.getName());
		setPhoneNumber(staff.getPhoneNumber());
		setStaffId(staff.getStaffId());
		setState(staff.getState());
		
		if(staff.getRole() != null) {
			setRoleId(String.valueOf(staff.getRole().getId()));
		} else {
			setRoleId("");
		}
		
		refreshInterests(staff.getInterests());
		refreshPublications(staff.getPublications());
		refreshAchievements(staff.getAchievements());
		refreshMemberships(staff.getMemberships());
		// TODO: RK: Other staff details population
	}
	
	private void populateModel(Staff staff) {
		staff.setAddress1(getAddress1());
		staff.setAddress2(getAddress2());
		staff.setCity(getCity());
		staff.setCollege(getCollege());
		staff.setCountry(getCountry());
		staff.setDepartment(getDepartment());
		staff.setDesignation(getDesignation());
		staff.setDob(getDob());
		staff.setDoj(getDoj());
		staff.setEmail(getEmail());
		staff.setGender(getGender());
		staff.setName(getName());
		staff.setPhoneNumber(getPhoneNumber());
//		staff.setStaffId(getStaffId());
		staff.setState(getState());
		
		// TODO: RK: Other persistable object population
	}
	
	private void clearForm() {
		setAddress1(StringUtils.EMPTY);
		setAddress2(StringUtils.EMPTY);
		setCity(StringUtils.EMPTY);
		setCollege(StringUtils.EMPTY);
		setCountry(StringUtils.EMPTY);
		setDepartment(StringUtils.EMPTY);
		setDesignation(StringUtils.EMPTY);
		setDob(null);
		setDoj(null);
		setEmail(StringUtils.EMPTY);
		setGender(StringUtils.EMPTY);
		setName(StringUtils.EMPTY);
		setPhoneNumber(0);
		setStaffId(StringUtils.EMPTY);
		setState(StringUtils.EMPTY);
		setRoleId("");
		
		setInterests(new ArrayList<StaffInterest>());
		setPublications(new ArrayList<Publication>());
		setAchievements(new ArrayList<Achievement>());
		setMemberships(new ArrayList<Membership>());
	}
	
}
