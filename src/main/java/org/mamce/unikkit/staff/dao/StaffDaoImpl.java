package org.mamce.unikkit.staff.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public List<Staff> findStaffs(Set<String> staffIds) {
		Disjunction staffIdOrCondition = Restrictions.disjunction(); // A or B or C
		DetachedCriteria criteria = DetachedCriteria.forClass(Staff.class);
		if(staffIds != null && staffIds.size() > 0) {
			for (Iterator<String> iterator = staffIds.iterator(); iterator.hasNext();) {
				String staffId = (String) iterator.next();
				staffIdOrCondition.add(Restrictions.eq("staffId", staffId));
			}
			criteria.add(staffIdOrCondition);
		}
		
		return getHibernateTemplate().findByCriteria(criteria);
	}
}
