package org.mamce.unikkit.model.role;

import java.util.Set;

import org.mamce.unikkit.model.BaseModel;
import org.mamce.unikkit.model.Menu;

public class Role extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Set<Menu> menu;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the menu
	 */
	public Set<Menu> getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Set<Menu> menu) {
		this.menu = menu;
	}
	

}
