package org.mamce.unikkit.web.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.mamce.unikkit.menu.manager.MenuManager;
import org.mamce.unikkit.model.Menu;
import org.mamce.unikkit.model.role.Role;
import org.mamce.unikkit.role.manager.RoleManager;

@ManagedBean
@RequestScoped
public class DropDownBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value=MP_ROLE_MANAGER)
	private RoleManager roleManager;
	
	@ManagedProperty(value=MP_MENU_MANAGER)
	private MenuManager menuManager;

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
	
	/**
	 * @return the menuManager
	 */
	public MenuManager getMenuManager() {
		return menuManager;
	}

	/**
	 * @param menuManager the menuManager to set
	 */
	public void setMenuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public List<Role> getRoles() {
		return roleManager.findAllRoles();
	}
	
	public List<Menu> getMenu() {
		return menuManager.findAllMenu();
	}
}
