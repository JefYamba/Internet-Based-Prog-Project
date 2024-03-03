package cg.jefy.IBPProject.security.services.impl;

import cg.jefy.IBPProject.entities.User;
import cg.jefy.IBPProject.repositories.UserRepository;
import cg.jefy.IBPProject.security.entities.Account;
import cg.jefy.IBPProject.security.entities.Role;
import cg.jefy.IBPProject.security.repositories.AccountRepository;
import cg.jefy.IBPProject.security.repositories.RoleRepository;
import cg.jefy.IBPProject.security.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author: JefYamba
 */

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private PasswordEcoder

    @Override
    public Account addNew(Long userId, String username, String password) {
        Account existingAccount = accountRepository.findByUsername(username);
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) throw new RuntimeException("No user to assign th account");
        if (existingAccount!= null) throw new RuntimeException("Account already exist!");

        Account account = Account.builder()
                .username(username)
                .password(password)
                .user(user)

                .build();


        return null;
    }

    @Override
    public Role addNewRole(String role) {
        return null;
    }

    @Override
    public void addRoleToAccount(String username, String role) {

    }

    @Override
    public void removeRoleFormAccount(String username, String role) {

    }
}
