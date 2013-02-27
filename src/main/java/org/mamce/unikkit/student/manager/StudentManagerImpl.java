package org.mamce.unikkit.student.manager;

import java.util.List;

import org.mamce.unikkit.model.student.Student;
import org.mamce.unikkit.student.dao.StudentDao;

/**
 * @author Ramesh
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
	

}
