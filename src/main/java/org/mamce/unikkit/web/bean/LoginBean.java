package org.mamce.unikkit.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.mamce.unikkit.common.util.Constants;
import org.mamce.unikkit.common.util.FacesUtils;
import org.mamce.unikkit.common.util.UnikkUtils;
import org.mamce.unikkit.model.user.User;
import org.mamce.unikkit.user.manager.UserManager;


/**
 * @author IT09B007 - Ganesh
 *
 */
@ManagedBean
@RequestScoped
public class LoginBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(LoginBean.class);
	
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
		User user = userManager.findUser(getUsername(), UnikkUtils.hashIt(getPassword()));
		
		if(user == null) {
			setUsername("");
			LOGGER.info("Invalid username / password. Try again.");
			FacesUtils.addErrorMessage("Invalid username - password. Try again.");
			return "login";
		}
		
		FacesUtils.setSessionAttribute(Constants.USER_SESSION_KEY, user);
		
		return "/home/dashboard";
	}
	
	public String logout() {
		FacesUtils.invalidateSession();
		
		return "/login.jsf";
	}
}
