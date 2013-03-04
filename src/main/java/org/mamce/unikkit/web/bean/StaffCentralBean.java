package org.mamce.unikkit.web.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.mamce.unikkit.model.staff.Staff;
import org.mamce.unikkit.staff.manager.StaffManager;
import org.mamce.unikkit.web.dto.StaffDto;

@ManagedBean
@RequestScoped
public class StaffCentralBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(StaffCentralBean.class);
	
	@ManagedProperty(value=MP_STAFF_MANAGER)
	private StaffManager staffManager;
	
	private StaffDto searchCriteria;
	private StaffDto staffDetails;
	
	public StaffCentralBean() {
		searchCriteria = new StaffDto();
	}
	
	/**
	 * @return the searchCriteria
	 */
	public StaffDto getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria
	 *            the searchCriteria to set
	 */
	public void setSearchCriteria(StaffDto searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	/**
	 * @return the staffDetails
	 */
	public StaffDto getStaffDetails() {
		return staffDetails;
	}

	/**
	 * @param staffDetails the staffDetails to set
	 */
	public void setStaffDetails(StaffDto staffDetails) {
		this.staffDetails = staffDetails;
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

	public List<Staff> getStaffs() {
		return staffManager.findAllStaffs();
	}
	
	/*private List<ExperienceDto> getSampleWorkExp() {
		List<ExperienceDto> workExperience = new ArrayList<>();

		ExperienceDto exp = new ExperienceDto();
		exp.setBeginMonth("Jun");
		exp.setBeginYear("1990");
		exp.setEndMonth("Jan");
		exp.setEndYear("1999");
		exp.setDescription("Worked as a Lecturer, Department of CSE, Crescent Engineering College, Chennai, Tamil Nadu, India.");
		workExperience.add(exp);

		exp = new ExperienceDto();
		exp.setBeginMonth("Jun");
		exp.setBeginYear("2001");
		exp.setEndMonth("Feb");
		exp.setEndYear("2002");
		exp.setDescription("Worked as a Senior Lecturer in M.A.M College of Engineering, Department of CSE, Tiruchirappalli, Tamil Nadu, India.");
		workExperience.add(exp);

		exp = new ExperienceDto();
		exp.setBeginMonth("Jun");
		exp.setBeginYear("2004");
		exp.setEndMonth("Sep");
		exp.setEndYear("2007");
		exp.setDescription("Worked as an Assistant Professor, Department of IT, M.A.M College of Engineering, Tiruchirappalli, Tamil Nadu, India. ");
		workExperience.add(exp);

		exp = new ExperienceDto();
		exp.setBeginMonth("Sep");
		exp.setBeginYear("2007");
		exp.setEndMonth("");
		exp.setEndYear("Tilldate");
		exp.setDescription("Working as a Professor, Department of IT, M.A.M College of Engineering, Tiruchirappalli, Tamil Nadu, India. ");
		workExperience.add(exp);

		return workExperience;
	}
	
	private List<EducationDto> getSampleEducation() {
		List<EducationDto> education = new ArrayList<>();
		
		EducationDto edu = new EducationDto();
		edu.setDescription("Government College of Technology, Bharathiar University, Coimbatore, Tamil Nadu, India.");
		edu.setStream("B.E.");
		edu.setSpecialization("Computer Technology & Informatics");
		edu.setYearOfCompletion("1990");
		
		education.add(edu);
		
		edu = new EducationDto();
		edu.setDescription("INSDOC, CSIR, New Delhi, India.");
		edu.setStream("A.I.S");
		edu.setSpecialization("Associateship in Information Science");
		edu.setYearOfCompletion("1993");
		
		education.add(edu);
		
		return education;
	}
	
	private List<InterestDto> getSampleInterests() {
		List<InterestDto> interests = new ArrayList<>();
		InterestDto intrst = new InterestDto();
		intrst.setTitle("Distributed System");
		interests.add(intrst);
		
		intrst = new InterestDto();
		intrst.setTitle("Parallel Computing");
		interests.add(intrst);
		
		intrst = new InterestDto();
		intrst.setTitle("Computer Architecture");
		interests.add(intrst);
		
		intrst = new InterestDto();
		intrst.setTitle("Software Engineering");
		interests.add(intrst);
		
		return interests;
	}
	
	private List<AchivementDto> getSampleAchivementDto() {
		List<AchivementDto> achv = new ArrayList<>();
		
		AchivementDto ac = new AchivementDto();
		ac.setDescription("Coordinator, Workshop on \"Cloud Computing\" by Dr.Rajkumar Buyya, Professor, University of Melbourne, December 2009.");
		ac.setType("ORGZD");
		
		achv.add(ac);
		
		ac = new AchivementDto();
		ac.setDescription("Participated in Workshop on \"Research Directions in Distributed Computing\" conducted by JNTU, Anantapur, Decemeber 2010.");
		ac.setType("ATTND");
		
		achv.add(ac);
		
		return achv;
	}
	
	private List<MembershipDto> getSampleMemership() {
		List<MembershipDto> mbrshps = new ArrayList<>();
		
		MembershipDto mbr = new MembershipDto();
		
		mbr.setType("PRFNL");
		mbr.setDescription("Institution of Engineers - Life member.");
		mbrshps.add(mbr);
		
		mbr = new MembershipDto();
		
		mbr.setType("PRFNL");
		mbr.setDescription("Computer Society of India - Member.");
		mbrshps.add(mbr);
		
		return mbrshps;
	}
	
	private List<PublicationDto> getSamplePulications() {
		List<PublicationDto> publications = new ArrayList<>();
		
		PublicationDto pub = new PublicationDto();
		
		pub.setType("INTJRNL");
		pub.setDescription("Y.Mohamadi Begum and M.A. Maluk Mohamed, \"DEEPG: Dual Heap Overlay Resource Discovery Protocol for Mobile Grid\".");
		publications.add(pub);
		
		pub = new PublicationDto();
		
		pub.setType("INTCONF");
		pub.setDescription("Y.Mohamadi Begum and M.A. Maluk Mohamed, \" A Heap-based P2P Topology and Dynamic Resource Location Policy...");
		publications.add(pub);
		
		return publications;
	}*/
}
