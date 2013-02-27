package org.mamce.unikkit.student.semester.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.student.Semester;

public class SemesterDaoImpl extends UnikkITDaoSupport implements SemesterDao {

	@Override
	public List<Semester> findAllSemesters() {
		return getHibernateTemplate().find("from Semester");
	}

	@Override
	public Semester findSemesterById(long id) {
		return (Semester) getHibernateTemplate().get(Semester.class, id);
	}

	@Override
	public Semester findSemesterByCode(long code) {
		Criteria criteria = getSession().createCriteria(Semester.class);
		criteria.add(Expression.eq("code", code));
		
		List<Semester> result = criteria.list();
		
		return result != null? result.get(0) : null;
	}

}
