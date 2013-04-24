package org.mamce.unikkit.role.dao;

import java.util.List;

import org.mamce.unikkit.model.role.Role;

public interface RoleDao {

	List<Role> findAllRole();
	Role findRoleById(long id);
	void saveRole(Role role);
	void saveAllRole(List<Role> roles);
	void delete(Role role);
}
