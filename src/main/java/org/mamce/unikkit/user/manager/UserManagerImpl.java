package org.mamce.unikkit.user.manager;

import java.util.List;

import org.mamce.unikkit.model.user.User;
import org.mamce.unikkit.user.dao.UserDao;

/**
 * @author Ramesh
 *
 */
public class UserManagerImpl implements UserManager {

	private UserDao userDao;
	
	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public User findUserById(long id) {
		return userDao.findUserById(id);
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public void saveAllUser(List<User> users) {
		userDao.saveAllUser(users);
	}

	@Override
	public User findUser(String userName, String hashedPassword) {
		return userDao.findUser(userName, hashedPassword);
	}

}
