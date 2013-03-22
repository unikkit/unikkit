package org.mamce.unikkit.staff.manager;

import java.util.List;

import org.mamce.unikkit.model.staff.Staff;

/**
 * @author Ramesh
 *
 */
public interface StaffManager {

	void saveStaff(Staff staff);
	void saveAllStaff(List<Staff> staffs);
	List<Staff> findAllStaffs();
	Staff findStaffById(long id);

}