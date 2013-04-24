package org.mamce.unikkit.role.manager;

import java.util.List;

import org.mamce.unikkit.model.role.Role;
import org.mamce.unikkit.role.dao.RoleDao;

/**
 * @author Ramesh
 *
 */
public class RoleManagerImpl implements RoleManager {

	private RoleDao roleDao;
	
	/**
	 * @return the roleDao
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public void saveRole(Role role) {
		roleDao.saveRole(role);
	}

	@Override
	public void saveAllRole(List<Role> roles) {
		roleDao.saveAllRole(roles);
	}

	@Override
	public List<Role> findAllRoles() {
		return roleDao.findAllRole();
	}

	@Override
	public Role findRoleById(long id) {
		return roleDao.findRoleById(id);
	}

	@Override
	public void delete(Role role) {
		roleDao.delete(role);
	}

}
