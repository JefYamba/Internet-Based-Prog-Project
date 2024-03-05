package cg.jefy.IBPProject.repositories;

import cg.jefy.IBPProject.entities.Authority;
import cg.jefy.IBPProject.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: JefYamba
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
