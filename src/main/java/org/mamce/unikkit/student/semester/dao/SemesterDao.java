package org.mamce.unikkit.student.semester.dao;

import java.util.List;

import org.mamce.unikkit.model.student.Semester;

public interface SemesterDao {

	List<Semester> findAllSemesters();
	Semester findSemesterById(long id);
	Semester findSemesterByCode(long code);
}
