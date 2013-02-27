package org.mamce.unikkit.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.mamce.unikkit.common.util.UnikkUtils;
import org.mamce.unikkit.model.user.User;
import org.mamce.unikkit.user.manager.UserManager;


/**
 * @author Ramesh
 *
 */
@ManagedBean
@RequestScoped
public class LoginBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Dependency Injection from Spring
	@ManagedProperty(value = MP_USER_MANAGER)
	private UserManager userManager;
	
	private String username;
	private String password;
	
	public LoginBean() {
	}
	
	/**
	 * @return the userManager
	 */
	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * @param userManager the userManager to set
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

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

	public String login() {
		System.out.println("Test login...");
		
		User user = userManager.findUser(getUsername(), UnikkUtils.hashIt(getPassword()));
		
		if(user == null) {
			System.out.println("Invalid username / password. Try again.");
			return "login";
		}
		
		// TODO: RK set user in session
		
		return "/home/dashboard";
	}
}
