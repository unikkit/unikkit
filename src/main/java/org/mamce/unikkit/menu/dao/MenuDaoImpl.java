package org.mamce.unikkit.menu.dao;

import java.util.List;

import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.Menu;

/**
 * @author Ramesh
 *
 */
public class MenuDaoImpl extends UnikkITDaoSupport<Menu> implements MenuDao {

	@Override
	public List<Menu> findAllMenus() {
		return getHibernateTemplate().find("from Menu where active = 1");
	}

	@Override
	public Menu findMenuById(long id) {
		return (Menu) getHibernateTemplate().get(Menu.class, id);
	}

	@Override
	public void saveMenu(Menu menu) {
		saveObject(menu);
	}

	@Override
	public void saveAllMenu(List<Menu> menus) {
		saveAll(menus);		
	}

	
}
