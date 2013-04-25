package org.mamce.unikkit.web.bean;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.mamce.unikkit.common.util.Constants;
import org.mamce.unikkit.common.util.FacesUtils;
import org.mamce.unikkit.common.util.UnikkUtils;
import org.mamce.unikkit.model.Menu;
import org.mamce.unikkit.model.role.Role;
import org.mamce.unikkit.model.user.User;
import org.mamce.unikkit.role.manager.RoleManager;
import org.mamce.unikkit.user.manager.UserManager;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;


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
	
	@ManagedProperty(value=MP_ROLE_MANAGER)
	private RoleManager roleManager;
	
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

	/**
	 * @return the roleManager
	 */
	public RoleManager getRoleManager() {
		return roleManager;
	}

	/**
	 * @param roleManager the roleManager to set
	 */
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
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
		formUserMenu(user);
		
		return "/home/dashboard";
	}
	
	public String logout() {
		FacesUtils.invalidateSession();
		
		return "/login.jsf";
	}
	
	private void formUserMenu(User user) {
		MenuModel menuModel = new DefaultMenuModel();
		
		if(user != null) {
			menuModel = new DefaultMenuModel();
			MenuItem home = new MenuItem();
			home.setUrl("/home/dashboard.xhtml");
			home.setValue("Home");
			home.setIcon("ui-icon-home");
			
			menuModel.addMenuItem(home);
			
			if(user.getRole() != null) {
				Role userRole = user.getRole();

				if(userRole != null) {
					Role freshRole = roleManager.findRoleById(userRole.getId());

					if(freshRole != null) {
						Set<Menu> menus = freshRole.getMenu();
						
						for (Menu menu : menus) {
							Submenu sub = new Submenu();
							Set<org.mamce.unikkit.model.MenuItem> subMenuItems = menu.getMenuItems();
							
							sub.setIcon(menu.getIcon());
							sub.setLabel(menu.getMenuText());
							
							for (org.mamce.unikkit.model.MenuItem subMenuItem : subMenuItems) {
								MenuItem item = new MenuItem();
								item.setValue(subMenuItem.getMenuText());
								item.setUrl(subMenuItem.getUri());
								item.setIcon(subMenuItem.getIcon());
								sub.getChildren().add(item);
							}
							menuModel.addSubmenu(sub);
						}
					}
				}
			}

			FacesUtils.setSessionAttribute(Constants.USER_MENU_MODEL, menuModel);
		}
	
	}
}
