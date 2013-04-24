package org.mamce.unikkit.model;


public class MenuItem extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String menuText;
	private Menu parent;
	private String icon;
	private String uri;
	
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
	

}
