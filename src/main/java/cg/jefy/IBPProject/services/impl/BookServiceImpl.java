package cg.jefy.IBPProject.services.impl;

import cg.jefy.IBPProject.entities.Book;
import cg.jefy.IBPProject.repositories.BookRepository;
import cg.jefy.IBPProject.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author: JefYamba
 */
@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {

        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()){

            Book existingBook = optionalBook.get();

            existingBook.setIsbn(book.getIsbn());
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPublisher(book.getPublisher());
            existingBook.setUnitPrice(book.getUnitPrice());

            bookRepository.save(existingBook);
        }

        return null;
    }

    @Override
    public void deleteBook(Long id) {
        if (bookRepository.findById(id).isPresent()){
            bookRepository.deleteById(id);
        }
    }
}
