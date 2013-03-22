package org.mamce.unikkit.dao.support;

import java.util.ArrayList;
import java.util.List;

import org.mamce.unikkit.common.util.UnikkUtils;
import org.mamce.unikkit.model.BaseModel;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Ramesh
 *
 * @param <T>
 */
public class UnikkITDaoSupport<T extends BaseModel> extends HibernateDaoSupport {

	protected T get(Class<? extends BaseModel> clazz, long id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}
	
	protected List<T> findByQueryString(String queryString) {
		return getHibernateTemplate().find(queryString);
	}
	
	protected void saveObject(T t) {
		t.setUpdatedDate(UnikkUtils.getToday());
		
		getHibernateTemplate().saveOrUpdate(t);
	}
	
	protected void saveAll(List<T> entities) {
		List<T> savableEntities = new ArrayList<>();
		
		for (T entity : entities) {
			entity.setUpdatedDate(UnikkUtils.getToday());
			savableEntities.add(entity);
		}
		
		getHibernateTemplate().saveOrUpdateAll(savableEntities);
	}
	
	protected void deleteObject(T t) {
		getHibernateTemplate().delete(t);
	}
	
}
