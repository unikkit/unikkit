package org.mamce.unikkit.model;

import java.util.Set;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class Menu extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String menuText;
	private boolean defaultMenu;
	private String icon;
	private String uri;
	private int ordr;
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
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
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
	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}
	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	/**
	 * @return the ordr
	 */
	public int getOrdr() {
		return ordr;
	}
	/**
	 * @param ordr the ordr to set
	 */
	public void setOrdr(int ordr) {
		this.ordr = ordr;
	}
	
	
}
