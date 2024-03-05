package cg.jefy.IBPProject.services.impl;

import cg.jefy.IBPProject.entities.Authority;
import cg.jefy.IBPProject.entities.Role;
import cg.jefy.IBPProject.repositories.AuthorityRepository;
import cg.jefy.IBPProject.repositories.RoleRepository;
import cg.jefy.IBPProject.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: JefYamba
 */
@Service
@AllArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    @Override
    public Role addNew(String roleName) {
        Role role = roleRepository.findById(roleName).orElse(null);

        if (role != null) throw new RuntimeException(String.format("Role : %s already exist!", roleName));

        role = Role.builder()
                .role(roleName)
                .build();

        return roleRepository.save(role);
    }

    @Override
    public void addAuthorityToRole(String roleName, String authorityName) {
        Role role = roleRepository.findById(roleName).orElse(null);
        Authority authority = authorityRepository.findById(authorityName).orElse(null);

        if (role == null) throw new RuntimeException(String.format("Role : %s don't exist!", roleName));
        if (authority == null) throw new RuntimeException(String.format("Authority : %s don't exist!", authorityName));

        role.getAuthorities().add(authority);

        roleRepository.save(role);
    }

    @Override
    public void removeAuthorityFromRole(String roleName, String authorityName) {
        Role role = roleRepository.findById(roleName).orElse(null);
        Authority authority = authorityRepository.findById(authorityName).orElse(null);

        if (role == null) throw new RuntimeException(String.format("Role : %s don't exist!", roleName));
        if (authority == null) throw new RuntimeException(String.format("Authority : %s don't exist!", authorityName));

        role.getAuthorities().remove(authority);

        roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
