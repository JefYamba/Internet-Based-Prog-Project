package cg.jefy.IBPProject.mappers;

import cg.jefy.IBPProject.dtos.AppUserDTO;
import cg.jefy.IBPProject.entities.AppUser;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author: JefYamba
 */
@Service
public class AppUserToUserDTOMapper implements Function<AppUser, AppUserDTO> {
    @Override
    public AppUserDTO apply(AppUser appUser) {
        return AppUserDTO.builder()
                .id(appUser.getId())
                .firstname(appUser.getFirstname())
                .lastname(appUser.getLastname())
                .email(appUser.getEmail())
                .department(appUser.getDepartment())
                .role(appUser.getRole().getRole())
                .build();
    }
}
