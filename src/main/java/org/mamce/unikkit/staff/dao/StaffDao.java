package org.mamce.unikkit.staff.dao;

import java.util.List;
import java.util.Set;

import org.mamce.unikkit.model.staff.Staff;

public interface StaffDao {

	List<Staff> findAllStaff();
	Staff findStaffById(long id);
	void saveStaff(Staff staff);
	void saveAllStaff(List<Staff> staffs);
	List<Staff> findStaffs(Set<String> staffIds);
	int findTotalStaffByDepartment(String department);
}
