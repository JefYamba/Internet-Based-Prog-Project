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
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {

        if (bookRepository.findById(book.getId()).isPresent()){
            Book exitingBook = bookRepository.findById(book.getId()).get();
            exitingBook.setIsbn(book.getIsbn());
            exitingBook.setTitle(book.getTitle());
            exitingBook.setAuthor(book.getAuthor());
            exitingBook.setEditor(book.getEditor());
            exitingBook.setUnitPrice(book.getUnitPrice());
            exitingBook.setImage(book.getImage());

            bookRepository.save(exitingBook);
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
