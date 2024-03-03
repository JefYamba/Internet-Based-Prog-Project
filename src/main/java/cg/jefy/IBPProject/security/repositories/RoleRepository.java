package cg.jefy.IBPProject.security.repositories;

import cg.jefy.IBPProject.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: JefYamba
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
