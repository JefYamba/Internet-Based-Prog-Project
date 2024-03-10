package cg.jefy.IBPProject.security;

import cg.jefy.IBPProject.entities.AppUser;
import cg.jefy.IBPProject.entities.Authority;
import cg.jefy.IBPProject.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author: JefYamba
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.loadUserByUsername(username);
        if (appUser == null) throw new UsernameNotFoundException(String.format("AppUser %s not found", username));

        String[] roles = appUser.getRole().getAuthorities().stream().map(Authority::getAuthority).toArray(String[]::new);
        return User
                .withUsername(appUser.getEmail())
                .password(passwordEncoder.encode(appUser.getPassword()))
//                .passwordEncoder(s -> new BCryptPasswordEncoder().encode(s))
                .roles(roles)
                .build();
    }

}
