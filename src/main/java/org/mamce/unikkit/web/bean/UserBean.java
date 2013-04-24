package org.mamce.unikkit.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.mamce.unikkit.user.manager.UserManager;

/**
 * @author IT09B007 - Ganesh
 *
 */
@ManagedBean
@RequestScoped
public class UserBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Dependency Injection from Spring
	@ManagedProperty(value = MP_USER_MANAGER)
	private UserManager userManager;

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


	public void showUsers() {
		System.out.println(userManager.findAllUsers());
	}
	

}
