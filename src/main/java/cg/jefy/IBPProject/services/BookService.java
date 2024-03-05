package cg.jefy.IBPProject.services;

import cg.jefy.IBPProject.entities.Book;

import java.util.List;

/**
 * @author: JefYamba
 */
public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book addBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);



}
