package org.mamce.unikkit.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.mamce.unikkit.menu.manager.MenuManager;

/**
 * @author Ramesh
 *
 */
@ManagedBean
@RequestScoped
public class MenuBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Dependency Injection from Spring
	@ManagedProperty(value = MP_MENU_MANAGER)
	private MenuManager menuManager;

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
	
	public void showAllMenus() {
		System.out.println(menuManager.findAllMenu());
	}
}
