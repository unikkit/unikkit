package org.mamce.unikkit.dao.support;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mamce.unikkit.model.BaseModel;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Ramesh
 *
 * @param <T>
 */
public class UnikkITDaoSupport<T extends BaseModel> extends HibernateDaoSupport {

	private Date currentDate = new Date();
	
	protected T get(Class<? extends BaseModel> clazz, long id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}
	
	protected List<T> findByQueryString(String queryString) {
		return getHibernateTemplate().find(queryString);
	}
	
	protected void saveObject(T t) {
		if(t.getId() < 0) {
			t.setCreatedDate(currentDate);
		}
		t.setUpdatedDate(currentDate);
		
		getHibernateTemplate().saveOrUpdate(t);
	}
	
	protected void saveAll(List<T> entities) {
		List<T> savableEntities = new ArrayList<>();
		
		for (T entity : entities) {
			if(entity.getId() < 0) {
				entity.setCreatedDate(currentDate);
			}
			entity.setUpdatedDate(currentDate);
			savableEntities.add(entity);
		}
		
		getHibernateTemplate().saveOrUpdateAll(savableEntities);
	}
	
}
