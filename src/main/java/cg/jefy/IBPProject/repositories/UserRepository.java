package cg.jefy.IBPProject.repositories;

import cg.jefy.IBPProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: JefYamba
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
