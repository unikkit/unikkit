package org.mamce.unikkit.student.manager;

import java.util.List;

import org.mamce.unikkit.model.student.Student;

public interface StudentManager {

	void saveStudent(Student student);
	void saveAllStudent(List<Student> students);
	List<Student> findAllStudents();
	Student findStudentById(long id);
	int findTotalStudentsByBatch(int batch, String department);
	List<Object> findTotalBoysByBatch();
	List<Object> findTotalGirlsByBatch();
}
