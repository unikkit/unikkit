package org.mamce.unikkit.staff.manager;

import java.util.List;
import java.util.Set;

import org.mamce.unikkit.model.staff.Staff;
import org.mamce.unikkit.staff.dao.StaffDao;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class StaffManagerImpl implements StaffManager {

	private StaffDao staffDao;
	
	/**
	 * @return the staffDao
	 */
	public StaffDao getStaffDao() {
		return staffDao;
	}

	/**
	 * @param staffDao the staffDao to set
	 */
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public void saveStaff(Staff staff) {
		staffDao.saveStaff(staff);
	}

	@Override
	public void saveAllStaff(List<Staff> staffs) {
		staffDao.saveAllStaff(staffs);
	}

	@Override
	public List<Staff> findAllStaffs() {
		return staffDao.findAllStaff();
	}

	@Override
	public Staff findStaffById(long id) {
		return staffDao.findStaffById(id);
	}
	
	public List<Staff> findStaffs(Set<String> staffIds) {
		return staffDao.findStaffs(staffIds);
	}

	@Override
	public int findTotalStaffByDepartment(String department) {
		int count = staffDao.findTotalStaffByDepartment(department);
		
		if(count <= 0) {
			count++;
		}
		return count;
	}

	@Override
	public long findTotalMaleStaffs() {
		return staffDao.findTotalMaleStaffs();
	}

	@Override
	public long findTotalFemaleStaffs() {
		return staffDao.findTotalFemaleStaffs();
	}

}
