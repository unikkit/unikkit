package org.mamce.unikkit.student.dao;

import java.util.List;

import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.student.Student;

public class StudentDaoImpl extends UnikkITDaoSupport<Student> implements StudentDao {

	@Override
	public List<Student> findAllStudent() {
		return getHibernateTemplate().find("from Student");
	}

	public void saveStudent(Student student) {
		saveObject(student);
	}
	
	public void saveAllStudent(List<Student> students) {
		saveAll(students);
	}

	@Override
	public Student findStudentById(long id) {
		return (Student) getHibernateTemplate().get(Student.class, id);
	}
}
