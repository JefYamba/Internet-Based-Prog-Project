package cg.jefy.IBPProject.repositories;

import cg.jefy.IBPProject.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: JefYamba
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
