package org.mamce.unikkit.staff.manager;

import java.util.List;
import java.util.Set;

import org.mamce.unikkit.model.staff.Staff;

/**
 * @author IT09B007 - Ganesh
 *
 */
public interface StaffManager {

	void saveStaff(Staff staff);
	void saveAllStaff(List<Staff> staffs);
	List<Staff> findAllStaffs();
	Staff findStaffById(long id);
	List<Staff> findStaffs(Set<String> staffId);
	int findTotalStaffByDepartment(String department);
}
