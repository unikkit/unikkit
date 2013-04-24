package org.mamce.unikkit.role.manager;

import java.util.List;

import org.mamce.unikkit.model.role.Role;

/**
 * @author Ramesh
 *
 */
public interface RoleManager {

	void saveRole(Role role);
	void saveAllRole(List<Role> roles);
	List<Role> findAllRoles();
	Role findRoleById(long id);
	void delete(Role role);

}
