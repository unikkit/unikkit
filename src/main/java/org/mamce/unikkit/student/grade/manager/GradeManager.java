package org.mamce.unikkit.student.grade.manager;

import java.util.List;

import org.mamce.unikkit.model.student.Grade;

public interface GradeManager {

	List<Grade> findAllGrades();
	Grade findGradeById(long id);
	void saveGrade(Grade grade);
	void saveAllGrade(List<Grade> grades);
}
