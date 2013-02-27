package org.mamce.unikkit.model.user;

import java.util.Set;

import org.mamce.unikkit.model.BaseModel;
import org.mamce.unikkit.model.Menu;

/**
 * @author Ramesh
 *
 */
public class User extends BaseModel {

	private String username;
	private String password;
	private Set<Menu> userMenu;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userMenu
	 */
	public Set<Menu> getUserMenu() {
		return userMenu;
	}
	/**
	 * @param userMenu the userMenu to set
	 */
	public void setUserMenu(Set<Menu> userMenu) {
		this.userMenu = userMenu;
	}
	
}
