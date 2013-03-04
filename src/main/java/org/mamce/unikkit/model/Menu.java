package org.mamce.unikkit.model;

import java.util.Set;

/**
 * @author Ramesh
 *
 */
public class Menu extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String menuText;
	private boolean defaultMenu;
	private Set<MenuItem> menuItems;
	
	/**
	 * @return the menuText
	 */
	public String getMenuText() {
		return menuText;
	}
	/**
	 * @param menuText the menuText to set
	 */
	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}
	/**
	 * @return the defaultMenu
	 */
	public boolean isDefaultMenu() {
		return defaultMenu;
	}
	/**
	 * @param defaultMenu the defaultMenu to set
	 */
	public void setDefaultMenu(boolean defaultMenu) {
		this.defaultMenu = defaultMenu;
	}
	/**
	 * @return the menuItems
	 */
	public Set<MenuItem> getMenuItems() {
		return menuItems;
	}
	/**
	 * @param menuItems the menuItems to set
	 */
	public void setMenuItems(Set<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	
}
