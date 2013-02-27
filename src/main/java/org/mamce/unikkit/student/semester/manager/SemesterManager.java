package org.mamce.unikkit.student.semester.manager;

import java.util.List;

import org.mamce.unikkit.model.student.Semester;

public interface SemesterManager {

	List<Semester> findAllSemesters();
	Semester findSemesterById(long id);
	Semester findSemesterByCode(long code);

}
