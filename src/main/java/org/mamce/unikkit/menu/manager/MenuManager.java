package org.mamce.unikkit.menu.manager;

import java.util.List;

import org.mamce.unikkit.model.Menu;

public interface MenuManager {
	
	List<Menu> findAllMenu();
	Menu findMenuById(long id);
	List<Menu> findMenuByIds(List<Long> id);
	void saveMenu(Menu menu);
	void saveAllMenu(List<Menu> menus);
}
