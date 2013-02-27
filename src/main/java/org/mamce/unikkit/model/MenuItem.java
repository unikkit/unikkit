package org.mamce.unikkit.model;


public class MenuItem extends BaseModel {

	private String menuText;
	private Menu parent;
	
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
	 * @return the parent
	 */
	public Menu getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Menu parent) {
		this.parent = parent;
	}

}
