package org.mamce.unikkit.student.dao;

import java.util.List;

import org.mamce.unikkit.model.student.Student;

public interface StudentDao {

	List<Student> findAllStudent();
	Student findStudentById(long id);
	void saveStudent(Student student);
	void saveAllStudent(List<Student> students);
}
