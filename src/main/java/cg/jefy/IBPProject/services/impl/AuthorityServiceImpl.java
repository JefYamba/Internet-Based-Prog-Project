package cg.jefy.IBPProject.services.impl;

import cg.jefy.IBPProject.entities.Authority;
import cg.jefy.IBPProject.entities.Role;
import cg.jefy.IBPProject.repositories.AuthorityRepository;
import cg.jefy.IBPProject.repositories.RoleRepository;
import cg.jefy.IBPProject.services.AuthorityService;
import cg.jefy.IBPProject.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: JefYamba
 */
@Service
@AllArgsConstructor
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;
    @Override
    public Authority addNew(String authorityName) {
        Authority authority = authorityRepository.findById(authorityName).orElse(null);

        if (authority != null) throw new RuntimeException(String.format("Role : %s already exist!", authorityName));

        authority = Authority.builder()
                .authority(authorityName)
                .build();

        return authorityRepository.save(authority);
    }
}
