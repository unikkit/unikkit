package org.mamce.unikkit.student.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
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

	@Override
	public int findTotalStudentsByBatch(int batch, String department) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		criteria.add(Expression.eq("batch", new Integer(batch)));
		criteria.add(Expression.eq("department", department));
		criteria.setProjection(Projections.countDistinct("rollNumber"));
		
		List resultSet = getHibernateTemplate().findByCriteria(criteria);

		Integer count = new Integer(0);
		if(resultSet != null && !resultSet.isEmpty()) {
			count = (Integer) resultSet.get(0);
		}
		
		return count.intValue();
	}
}
