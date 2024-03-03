package cg.jefy.IBPProject.security.services;

import cg.jefy.IBPProject.entities.User;
import cg.jefy.IBPProject.security.entities.Account;
import cg.jefy.IBPProject.security.entities.Role;
import org.springframework.stereotype.Service;

/**
 * @author: JefYamba
 */
public interface AccountService {
    Account addNew(Long userId, String username, String password);

    Role addNewRole(String role);

    void addRoleToAccount(String username, String role);

    void removeRoleFormAccount(String username, String role);
}
