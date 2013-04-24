package org.mamce.unikkit.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.mamce.unikkit.common.util.Constants;
import org.mamce.unikkit.common.util.FacesUtils;
import org.mamce.unikkit.common.util.UnikkUtils;
import org.mamce.unikkit.model.student.Grade;
import org.mamce.unikkit.model.student.Semester;
import org.mamce.unikkit.model.student.Student;
import org.mamce.unikkit.student.manager.StudentManager;
import org.mamce.unikkit.student.semester.manager.SemesterManager;

@ManagedBean
@RequestScoped
public class StudentDetailsBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(StudentDetailsBean.class);
	
	@ManagedProperty(value=MP_STUDENT_MANAGER)
	private StudentManager studentManager;
	
	@ManagedProperty(value=MP_SEMESTER_MANAGER)
	private SemesterManager semesterManager;
	
	private Student selectedStudent;
	
	private String name;
	private String address1;
	private String address2;
	private String rollNumber;
	private String registrationNumber;
	private int batch;
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
	private int twelthYop;
	private int diplamoYop;
	private String tenthGpa;
	private String twelthGpa;
	private String diplamoGpa;
	private String updatedBy;
	private List<Semester> semesters;
	
	/**
	 * @return the studentManager
	 */
	public StudentManager getStudentManager() {
		return studentManager;
	}

	/**
	 * @param studentManager the studentManager to set
	 */
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	/**
	 * @return the semesterManager
	 */
	public SemesterManager getSemesterManager() {
		return semesterManager;
	}

	/**
	 * @param semesterManager the semesterManager to set
	 */
	public void setSemesterManager(SemesterManager semesterManager) {
		this.semesterManager = semesterManager;
	}

	/**
	 * @return the selectedStudent
	 */
	public Student getSelectedStudent() {
		return selectedStudent;
	}

	/**
	 * @param selectedStudent the selectedStudent to set
	 */
	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
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
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the semesters
	 */
	public List<Semester> getSemesters() {
		return semesters;
	}

	/**
	 * @param semesters the semesters to set
	 */
	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}

	public String studentDetails() {
		if(selectedStudent == null) {
			// TODO: RK: Add error message here
			
			return "studentDetails";
		}
		populateForm(selectedStudent);
		return "studentDetails";
	}
	
	public String cancelStudentDetails() {
		return "studentCentral";
	}
	
	public String addNewStudent() {
		setId(Constants.UNSAVED_ID);
		clearForm();
		return "studentDetails";
	}
	
	public void saveStudentDetails() {
		Student student = null;
		try {
			if(getId() < 0) {
				int sequence = studentManager.findTotalStudentsByBatch(getBatch(), getDepartment());
				setRollNumber(UnikkUtils.generateRollNumber(getBatch(), sequence));
				
				student = new Student();
				student.setRollNumber(getRollNumber());
			} else {
				student = studentManager.findStudentById(getId());

				if(student == null) {
					FacesUtils.addErrorMessage("Student Information not found. Could not update.");
					return;
				}
			}
			populateModel(student);
			studentManager.saveStudent(student);
			populateForm(student);
			FacesUtils.addInfoMessage("Student information saved successfully!");
		} catch (Exception e) {
			LOGGER.error("Error while saving student details", e);
		}
	}
	
	private void populateForm(Student student) {
		setAddress1(student.getAddress1());
		setAddress2(student.getAddress2());
		setArrears(student.getArrears());
		setArrearsHistory(student.getArrearsHistory());
		setBatch(student.getBatch());
		setCity(student.getCity());
		setCollege(student.getCollege());
		setCountry(student.getCountry());
		setDepartment(student.getDepartment());
		setDiplamoGpa(student.getDiplamoGpa());
		setDob(student.getDob());
		setEmail(student.getEmail());
		setGender(student.getGender());
		setId(student.getId());
		setName(student.getName());
		setParentName(student.getParentName());
		setPhoneNumber(student.getPhoneNumber());
		setRegistrationNumber(student.getRegistrationNumber());
		setRollNumber(student.getRollNumber());
		setState(student.getState());
		setTenthGpa(student.getTenthGpa());
		setTwelthGpa(student.getTwelthGpa());
		setUpdatedBy(student.getUpdateBy());
		
		setSemesters(semesterManager.findAllSemesters());
		
		Set<Grade> studentGrade = student.getGrades();
		
		List<Grade> semGrade = new ArrayList<>();
		
		if(studentGrade != null && !studentGrade.isEmpty()) {
			List<Semester> semesters = semesterManager.findAllSemesters();
			long previousId = -1;
			
			if(semesters != null) {
				for (Semester semester : semesters) {
					if(semester != null) {
						long currentId = semester.getId();
						
						if(previousId < 0) previousId = currentId;
						
						if(currentId != previousId) {
							
						}
						
						
					}
				}
			}
		}
	}
	
	private void populateModel(Student student) {
		student.setAddress1(getAddress1());
		student.setAddress2(getAddress2());
		student.setArrears(getArrears());
		student.setArrearsHistory(getArrearsHistory());
		student.setBatch(getBatch());
		student.setCity(getCity());
		student.setCollege(getCollege());
		student.setCountry(getCountry());
		student.setDepartment(getDepartment());
		student.setDiplamoYop(getDiplamoYop());
		student.setDiplamoGpa(getDiplamoGpa());
		student.setDob(getDob());
		student.setEmail(getEmail());
		student.setGender(getGender());
		student.setId(getId());
		student.setName(getName());
		student.setParentName(getParentName());
		student.setPhoneNumber(getPhoneNumber());
		student.setRegistrationNumber(getRegistrationNumber());
		//student.setRollNumber(getRollNumber());
		student.setState(getState());
		student.setTenthYop(getTenthYop());
		student.setTenthGpa(getTenthGpa());
		student.setTwelthYop(getTwelthYop());
		student.setTwelthGpa(getTwelthGpa());
	}

	private void clearForm() {
		setAddress1(StringUtils.EMPTY);
		setAddress2(StringUtils.EMPTY);
		setArrears(Constants.ZERO);
		setArrearsHistory(Constants.ZERO);
		setBatch(Constants.ZERO);
		setCity(StringUtils.EMPTY);
		setCollege(StringUtils.EMPTY);
		setCountry(StringUtils.EMPTY);
		setDepartment(StringUtils.EMPTY);
		setDiplamoGpa(StringUtils.EMPTY);
		setDob(null);
		setEmail(StringUtils.EMPTY);
		setGender(StringUtils.EMPTY);
		setName(StringUtils.EMPTY);
		setParentName(StringUtils.EMPTY);
		setPhoneNumber(Constants.ZERO);
		setRegistrationNumber(StringUtils.EMPTY);
		setRollNumber(StringUtils.EMPTY);
		setState(StringUtils.EMPTY);
		setTenthGpa(StringUtils.EMPTY);
		setTwelthGpa(StringUtils.EMPTY);
		setUpdatedBy(StringUtils.EMPTY);
		
		//setSemesters(semesterManager.findAllSemesters());
	}
}
