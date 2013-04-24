package org.mamce.unikkit.web.bean;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.mamce.unikkit.common.util.Constants;
import org.mamce.unikkit.common.util.FacesUtils;
import org.mamce.unikkit.model.Menu;
import org.mamce.unikkit.model.role.Role;
import org.mamce.unikkit.model.user.User;
import org.mamce.unikkit.role.manager.RoleManager;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

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

	private MenuModel menuModel;
	
	@ManagedProperty(value=MP_ROLE_MANAGER)
	private RoleManager roleManager;
	
	/**
	 * @param menuModel the menuModel to set
	 */
	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
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

	public MenuModel getMenuModel() {
		User user = FacesUtils.getLoggedInUser();
		menuModel = new DefaultMenuModel();
		
		if(user != null) {
			menuModel = (MenuModel) FacesUtils.getSessionAttribute(Constants.USER_MENU_MODEL);
			
			if(menuModel != null) {
				return menuModel;
			}
			
			if(user.getRole() != null) {
				Role userRole = user.getRole();

				if(userRole != null) {
					Role freshRole = roleManager.findRoleById(userRole.getId());

					if(freshRole != null) {
						Set<Menu> menus = freshRole.getMenu();
						menuModel = new DefaultMenuModel();
						
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
		return menuModel;
	}
}
