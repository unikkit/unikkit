package org.mamce.unikkit.user.dao;

import java.util.List;

import org.mamce.unikkit.model.user.User;

public interface UserDao {
	List<User> findAllUsers();
	User findUser(String userName, String hashedPassword);
	User findUserById(long id);
	void saveUser(User user);
	void saveAllUser(List<User> users);
}
