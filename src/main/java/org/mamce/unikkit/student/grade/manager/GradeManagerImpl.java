package org.mamce.unikkit.student.grade.manager;

import java.util.List;

import org.mamce.unikkit.model.student.Grade;
import org.mamce.unikkit.student.grade.dao.GradeDao;


/**
 * @author IT09B007 - Ganesh
 *
 */
public class GradeManagerImpl implements GradeManager {

	private GradeDao gradeDao;
	
	/**
	 * @return the gradeDao
	 */
	public GradeDao getGradeDao() {
		return gradeDao;
	}

	/**
	 * @param gradeDao the gradeDao to set
	 */
	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	@Override
	public List<Grade> findAllGrades() {
		return gradeDao.findAllGrades();
	}

	@Override
	public Grade findGradeById(long id) {
		return gradeDao.findGradeById(id);
	}

	@Override
	public void saveGrade(Grade grade) {
		gradeDao.saveGrade(grade);
	}

	@Override
	public void saveAllGrade(List<Grade> grades) {
		gradeDao.saveAllGrade(grades);
	}

}
