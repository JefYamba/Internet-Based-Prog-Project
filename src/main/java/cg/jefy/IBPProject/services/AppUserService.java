package cg.jefy.IBPProject.services;

import cg.jefy.IBPProject.dtos.AppUserDTO;
import cg.jefy.IBPProject.entities.AppUser;

import java.util.List;

/**
 * @author: JefYamba
 */
public interface AppUserService {


    List<AppUserDTO> getAllUsers();

    AppUserDTO getUserById(Long id);

    AppUser addUser(AppUserDTO appUserDTO);

    AppUser updateUser(Long id, AppUserDTO appUserDTO);

    void deleteUser(Long id);

    AppUser loadUserByUsername(String username);


}
