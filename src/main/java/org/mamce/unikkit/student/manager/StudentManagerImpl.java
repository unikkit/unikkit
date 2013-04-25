package org.mamce.unikkit.student.manager;

import java.util.List;

import org.mamce.unikkit.model.student.Student;
import org.mamce.unikkit.student.dao.StudentDao;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class StudentManagerImpl implements StudentManager {

	private StudentDao studentDao;
	
	/**
	 * @return the studentDao
	 */
	public StudentDao getStudentDao() {
		return studentDao;
	}

	/**
	 * @param studentDao the studentDao to set
	 */
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
	}

	@Override
	public List<Student> findAllStudents() {
		return studentDao.findAllStudent();
	}

	@Override
	public void saveAllStudent(List<Student> students) {
		studentDao.saveAllStudent(students);
	}

	@Override
	public Student findStudentById(long id) {
		return studentDao.findStudentById(id);
	}

	@Override
	public int findTotalStudentsByBatch(int batch, String department) {
		int count = studentDao.findTotalStudentsByBatch(batch, department);
		if(count <= 0) {
			count = 1;
		}
		return count;
	}

	@Override
	public List<Object> findTotalBoysByBatch() {
		return studentDao.findTotalBoysByBatch();
	}

	@Override
	public List<Object> findTotalGirlsByBatch() {
		return studentDao.findTotalGirlsByBatch();
	}
	

}
