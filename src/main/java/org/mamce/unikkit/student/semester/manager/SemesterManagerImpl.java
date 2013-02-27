package org.mamce.unikkit.student.semester.manager;

import java.util.List;

import org.mamce.unikkit.model.student.Semester;
import org.mamce.unikkit.student.semester.dao.SemesterDao;


/**
 * @author Ramesh
 *
 */
public class SemesterManagerImpl implements SemesterManager {

	private SemesterDao semesterDao;
	
	/**
	 * @return the semesterDao
	 */
	public SemesterDao getSemesterDao() {
		return semesterDao;
	}

	/**
	 * @param semesterDao the semesterDao to set
	 */
	public void setSemesterDao(SemesterDao semesterDao) {
		this.semesterDao = semesterDao;
	}

	@Override
	public List<Semester> findAllSemesters() {
		return semesterDao.findAllSemesters();
	}

	@Override
	public Semester findSemesterById(long id) {
		return semesterDao.findSemesterById(id);
	}

	@Override
	public Semester findSemesterByCode(long code) {
		return semesterDao.findSemesterById(code);
	}

}
