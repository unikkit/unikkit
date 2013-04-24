package org.mamce.unikkit.role.dao;

import java.util.List;

import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.role.Role;

/**
 * @author Ramesh
 *
 */
public class RoleDaoImpl extends UnikkITDaoSupport<Role> implements RoleDao {

	@Override
	public List<Role> findAllRole() {
		return getHibernateTemplate().find("from Role");
	}

	public void saveRole(Role role) {
		saveObject(role);
	}
	
	public void saveAllRole(List<Role> roles) {
		saveAll(roles);
	}

	@Override
	public Role findRoleById(long id) {
		return (Role) getHibernateTemplate().get(Role.class, id);
	}

	public void delete(Role role) {
		deleteObject(role);
	}
}
