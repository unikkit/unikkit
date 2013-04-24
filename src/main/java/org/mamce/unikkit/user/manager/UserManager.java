package org.mamce.unikkit.user.manager;

import java.util.List;

import org.mamce.unikkit.model.user.User;

public interface UserManager {

	List<User> findAllUsers();
	User findUser(String userName, String hashedPassword);
	User findUserById(long id);
	User findUser(String userName);
	void saveUser(User user);
	void saveAllUser(List<User> users);
}
