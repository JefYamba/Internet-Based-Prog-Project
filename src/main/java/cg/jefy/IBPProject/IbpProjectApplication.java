package cg.jefy.IBPProject;

import cg.jefy.IBPProject.services.AuthorityService;
import cg.jefy.IBPProject.services.RoleService;
import cg.jefy.IBPProject.services.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IbpProjectApplication {

	private final RoleService roleService;
	private AuthorityService authorityService;

    public IbpProjectApplication(AppUserService appUserService, RoleService roleService, AuthorityService authorityService) {
        this.roleService = roleService;
        this.authorityService = authorityService;
    }

    public static void main(String[] args) {
		SpringApplication.run(IbpProjectApplication.class, args);
	}

}
