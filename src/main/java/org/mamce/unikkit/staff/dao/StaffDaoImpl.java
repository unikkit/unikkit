package org.mamce.unikkit.staff.dao;

import java.util.List;

import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.staff.Staff;

/**
 * @author Ramesh
 *
 */
public class StaffDaoImpl extends UnikkITDaoSupport<Staff> implements StaffDao {

	@Override
	public List<Staff> findAllStaff() {
		return getHibernateTemplate().find("from Staff");
	}

	public void saveStaff(Staff staff) {
		saveObject(staff);
	}
	
	public void saveAllStaff(List<Staff> staffs) {
		saveAll(staffs);
	}

	@Override
	public Staff findStaffById(long id) {
		return (Staff) getHibernateTemplate().get(Staff.class, id);
	}
}
