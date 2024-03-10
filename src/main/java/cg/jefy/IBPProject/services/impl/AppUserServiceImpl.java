package cg.jefy.IBPProject.services.impl;

import cg.jefy.IBPProject.dtos.AppUserDTO;
import cg.jefy.IBPProject.entities.AppUser;
import cg.jefy.IBPProject.mappers.AppUserToUserDTOMapper;
import cg.jefy.IBPProject.repositories.AppUserRepository;
import cg.jefy.IBPProject.repositories.RoleRepository;
import cg.jefy.IBPProject.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: JefYamba
 */
@Service
@Transactional
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final AppUserToUserDTOMapper appUserToUserDTOMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<AppUserDTO> getAllUsers() {
        return appUserRepository.findAll().stream().map(appUserToUserDTOMapper).collect(Collectors.toList());
    }

    @Override
    public AppUserDTO getUserById(Long id) {
        Optional<AppUser> optionalAppUser = appUserRepository.findById(id);
        return optionalAppUser.map(appUserToUserDTOMapper).orElse(null);

    }

    @Override
    public AppUser addUser(AppUserDTO appUserDTO) {
        if (appUserDTO.getFirstname() == null && appUserDTO.getLastname() == null && appUserDTO.getEmail() == null)
            throw new RuntimeException("Firstname, Lastname or Email missing!");

        AppUser appUserToUpdate = appUserRepository.findByEmail(appUserDTO.getEmail());
        if (appUserToUpdate != null)
            return null;

        AppUser newAppUser = AppUser.builder()
                .firstname(appUserDTO.getFirstname())
                .lastname(appUserDTO.getLastname())
                .email(appUserDTO.getEmail())
                .password(passwordEncoder.encode(appUserDTO.getEmail()))
                .department(appUserDTO.getDepartment())
                .role(roleRepository.findById(appUserDTO.getRole())
                        .orElseThrow(()-> new RuntimeException(
                        String.format("Role : %s Does not exist!", appUserDTO.getRole())
                )))
                .build();

        return appUserRepository.save(newAppUser);
    }

    @Override
    public AppUser updateUser(Long id, AppUserDTO appUserDTO) {
        if (appUserDTO.getFirstname() == null && appUserDTO.getLastname() == null && appUserDTO.getEmail() == null)
            throw new RuntimeException("Firstname, Lastname or Email missing!");

        AppUser appUserToUpdate = appUserRepository.findById(id).orElse(null);

        if (appUserToUpdate == null) throw new RuntimeException("AppUser don't exist!");

        appUserToUpdate.setFirstname(appUserDTO.getFirstname());
        appUserToUpdate.setLastname(appUserDTO.getLastname());
        appUserToUpdate.setEmail(appUserDTO.getEmail());
        appUserToUpdate.setDepartment(appUserDTO.getDepartment());
        appUserToUpdate.setRole(roleRepository.findById(appUserDTO.getRole())
                .orElseThrow(()-> new RuntimeException(
                String.format("Role : %s Does not exist!", appUserDTO.getRole())
        )));

        return appUserRepository.save(appUserToUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        appUserRepository.deleteById(id);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByEmail(username);
    }

    @Override
    public AppUserDTO getByEmail(String email) {
        AppUser appUser = appUserRepository.findByEmail(email);
        return appUserToUserDTOMapper.apply(appUser);
    }

}
