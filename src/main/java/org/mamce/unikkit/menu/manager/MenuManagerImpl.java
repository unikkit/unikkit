package org.mamce.unikkit.menu.manager;

import java.util.List;

import org.mamce.unikkit.menu.dao.MenuDao;
import org.mamce.unikkit.model.Menu;

/**
 * @author Ramesh
 *
 */
public class MenuManagerImpl implements MenuManager {

	private MenuDao menuDao;
	
	/**
	 * @return the menuDao
	 */
	public MenuDao getMenuDao() {
		return menuDao;
	}

	/**
	 * @param menuDao the menuDao to set
	 */
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<Menu> findAllMenu() {
		return menuDao.findAllMenus();
	}

	@Override
	public Menu findMenuById(long id) {
		return menuDao.findMenuById(id);
	}

	@Override
	public void saveMenu(Menu menu) {
		menuDao.saveMenu(menu);
		
	}

	@Override
	public void saveAllMenu(List<Menu> menus) {
		menuDao.saveAllMenu(menus);
	}

}
