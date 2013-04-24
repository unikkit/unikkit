package org.mamce.unikkit.menu.dao;

import java.util.List;

import org.mamce.unikkit.model.Menu;

public interface MenuDao {

	List<Menu> findAllMenus();
	Menu findMenuById(long id);
	List<Menu> findMenuByIds(List<Long> id);
	void saveMenu(Menu menu);
	void saveAllMenu(List<Menu> menus);
}
