package cg.jefy.IBPProject.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author: JefYamba
 */
@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final PasswordEncoder passwordEncoder;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{


        return httpSecurity
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/dist/**").permitAll()
                                .requestMatchers("/images/**").permitAll()
                                .requestMatchers("/plugins/**").permitAll()
                                .requestMatchers("/users/profile").hasRole("USER")
                                .requestMatchers("/users/profile/**").hasRole("USER")
                                .requestMatchers("/books").hasRole("USER")
                                .requestMatchers("/books/view/**").hasRole("USER")
                                .requestMatchers("/books/**").hasRole("ADMIN")
                                .requestMatchers("/users").hasRole("ADMIN")
                                .requestMatchers("/users/**").hasRole("ADMIN")
                                .requestMatchers("/**").hasRole("USER")
                                .anyRequest().authenticated()
                        )
                .formLogin((formLogin) ->
                        formLogin
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .loginPage("/login")
                                .failureUrl("/login?failed")
                                .loginProcessingUrl("/")
                )
                .exceptionHandling((exception)->
                        exception.accessDeniedPage("/") // for denied access

                )
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return authenticationProvider;
    }


}
