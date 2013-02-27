package org.mamce.unikkit.menu.dao;

import java.util.List;

import org.mamce.unikkit.model.Menu;

public interface MenuDao {

	List<Menu> findAllMenus();
	Menu findMenuById(long id);
	void saveMenu(Menu menu);
	void saveAllMenu(List<Menu> menus);
}
