package org.mamce.unikkit.user.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.user.User;

/**
 * @author Ramesh
 *
 */
public class UserDaoImpl extends UnikkITDaoSupport<User> implements UserDao {

	@Override
	public List<User> findAllUsers() {
		String queryString = "from User where active = 1";
		return findByQueryString(queryString);
	}

	@Override
	public User findUserById(long id) {
		return get(User.class, id);
	}

	@Override
	public void saveUser(User user) {
		saveObject(user);
		
	}

	@Override
	public void saveAllUser(List<User> users) {
		saveAll(users);
	}

	@Override
	public User findUser(String userName, String hashedPassword) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Expression.eq("username", userName));
		criteria.add(Expression.eq("password", hashedPassword));
		criteria.add(Expression.eq("active", true));
		
		List<User> user = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		
		if(user != null && !user.isEmpty()) {
			return user.get(0);
		}
		return null;
	}

	@Override
	public User findUser(String userName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Expression.eq("username", userName));
		
		List<User> user = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		
		if(user != null && !user.isEmpty()) {
			return user.get(0);
		}
		return null;
	}

}
