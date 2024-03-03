package cg.jefy.IBPProject.services;

import cg.jefy.IBPProject.entities.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author: JefYamba
 */
public interface BookService {

    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Book addBook(Book book);

    Book updateBook(Book book);

    void deleteBook(Long id);



}
