package org.mamce.unikkit.web.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.mamce.unikkit.common.util.FacesUtils;
import org.mamce.unikkit.menu.manager.MenuManager;
import org.mamce.unikkit.model.Menu;
import org.mamce.unikkit.model.role.Role;
import org.mamce.unikkit.role.manager.RoleManager;

@ManagedBean
@ApplicationScoped
public class ManageAccessBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(ManageAccessBean.class);
	
	@ManagedProperty(value=MP_ROLE_MANAGER)
	private RoleManager roleManager;
	
	@ManagedProperty(value=MP_MENU_MANAGER)
	private MenuManager menuManager;
	
	private List<String> selectedMenus;
	private String selectedRole;
	

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

	/**
	 * @return the selectedMenus
	 */
	public List<String> getSelectedMenus() {
		return selectedMenus;
	}

	/**
	 * @param selectedMenus the selectedMenus to set
	 */
	public void setSelectedMenus(List<String> selectedMenus) {
		this.selectedMenus = selectedMenus;
	}
	
	/**
	 * @return the selectedRole
	 */
	public String getSelectedRole() {
		return selectedRole;
	}

	/**
	 * @param selectedRole the selectedRole to set
	 */
	public void setSelectedRole(String selectedRole) {
		this.selectedRole = selectedRole;
	}

	public void roleChangeEvent(ValueChangeEvent event) {
		String roleId = (String) event.getNewValue();
		try {
			if(StringUtils.isNotBlank(roleId)) {
				Role selectedRole = roleManager.findRoleById(Long.valueOf(roleId));

				if(selectedRole == null) {
					LOGGER.error("Unable to find the selected role with id:"+roleId);
				} else {
					selectedMenus = new ArrayList<>();

					Set<Menu> roleMenu = selectedRole.getMenu();
					if(roleMenu != null && !roleMenu.isEmpty()) {
						for (Menu menu : roleMenu) {
							selectedMenus.add(String.valueOf(menu.getId()));
						}

					} else {
						selectedMenus = new ArrayList<>();
					}
				}

			} else {
				selectedMenus = new ArrayList<>();
			}
		} catch (Exception e) {
			LOGGER.error("Sorry. Error while finding role menu access", e);
			FacesUtils.addFatalMessage("Sorry. Error while finding role menu access");
		}
		
	}
	
	public void saveRoleMenuSelection() {
		try {
			if(StringUtils.isNotBlank(selectedRole)) {
				Role role = roleManager.findRoleById(Long.valueOf(selectedRole));
				
				if(role == null) {
					LOGGER.error("Unable to find the selected role with id:"+selectedRole);
				} else {
					List<Long> menuIds = new ArrayList<>();
					Set<Menu> newMenuAccess = new HashSet<>();
					
					if(selectedMenus != null && !selectedMenus.isEmpty()) {
						for (String menuId : selectedMenus) {
							menuIds.add(Long.valueOf(menuId));
						}

						List<Menu> menuToAdd = menuManager.findMenuByIds(menuIds);

						newMenuAccess.addAll(menuToAdd);
						
					} 
					role.setMenu(newMenuAccess);
					roleManager.saveRole(role);
					FacesUtils.addInfoMessage("Role access saved successfully!");
				}
				
			}
		} catch (Exception e) {
			LOGGER.error("Sorry. Error while saving role access", e);
			FacesUtils.addFatalMessage("Sorry. Error while saving role access");
		}
		
	}
	
	public void cancelRoleSelection() {
		selectedMenus = new ArrayList<>();
		setSelectedRole("");
	}
}
