package org.mamce.unikkit.staff.dao;

import java.util.List;

import org.mamce.unikkit.model.staff.Staff;

public interface StaffDao {

	List<Staff> findAllStaff();
	Staff findStaffById(long id);
	void saveStaff(Staff staff);
	void saveAllStaff(List<Staff> staffs);
}