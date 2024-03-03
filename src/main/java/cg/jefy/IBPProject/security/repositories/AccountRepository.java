package cg.jefy.IBPProject.security.repositories;

import cg.jefy.IBPProject.security.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: JefYamba
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
