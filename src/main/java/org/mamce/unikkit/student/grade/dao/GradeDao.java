package org.mamce.unikkit.student.grade.dao;

import java.util.List;

import org.mamce.unikkit.model.student.Grade;

public interface GradeDao {

	List<Grade> findAllGrades();
	Grade findGradeById(long id);
	void saveGrade(Grade grade);
	void saveAllGrade(List<Grade> grades);
}
