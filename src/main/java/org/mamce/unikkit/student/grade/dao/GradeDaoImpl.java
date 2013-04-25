package org.mamce.unikkit.student.grade.dao;

import java.util.List;

import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.student.Grade;

public class GradeDaoImpl extends UnikkITDaoSupport<Grade> implements GradeDao {

	@Override
	public List<Grade> findAllGrades() {
		return getHibernateTemplate().find("from Grade");
	}

	@Override
	public Grade findGradeById(long id) {
		return (Grade) getHibernateTemplate().get(Grade.class, id);
	}

	@Override
	public void saveGrade(Grade grade) {
		saveObject(grade);
	}

	@Override
	public void saveAllGrade(List<Grade> grades) {
		saveAll(grades);
	}
	
	

}
