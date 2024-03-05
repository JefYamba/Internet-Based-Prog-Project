package cg.jefy.IBPProject.services;

import cg.jefy.IBPProject.entities.Role;

import java.util.List;

/**
 * @author: JefYamba
 */
public interface RoleService {
    Role addNew(String roleName);


    void addAuthorityToRole(String roleName, String authorityName);

    void removeAuthorityFromRole(String roleName, String authorityName);

    List<Role> getAllRoles();
}
