package cg.jefy.IBPProject.security;

/**
 * @author: JefYamba
 */
/*@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserService appUserService;
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.loadUserByUsername(username);
        if (appUser == null) throw new UsernameNotFoundException(String.format("AppUser %s not found", username));

        String[] roles = appUser.getRole().getAuthorities().stream().map(Authority::getAuthority).toArray(String[]::new);

        return User
                .withUsername(appUser.getEmail())
                .password(passwordEncoder.encode(appUser.getPassword()))
                .roles(roles)
                .build();
    }

}*/
