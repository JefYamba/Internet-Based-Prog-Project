package cg.jefy.IBPProject.repositories;

import cg.jefy.IBPProject.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: JefYamba
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
