package org.mamce.unikkit.menu.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.Menu;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class MenuDaoImpl extends UnikkITDaoSupport<Menu> implements MenuDao {

	@Override
	public List<Menu> findAllMenus() {
		return getHibernateTemplate().find("from Menu");
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

	@Override
	public List<Menu> findMenuByIds(List<Long> ids) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Menu.class);
		for (Long id : ids) {
			criteria.add(Expression.in("id", ids));
		}
		
		return getHibernateTemplate().findByCriteria(criteria);
	}

	
}
