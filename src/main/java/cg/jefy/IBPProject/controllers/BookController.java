package cg.jefy.IBPProject.controllers;

import cg.jefy.IBPProject.entities.Book;
import cg.jefy.IBPProject.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author: JefYamba
 */
@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping({"","/"})
    public String getAllBooksPage(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "pages/book-list";
    }

    @GetMapping("/new")
    public String getAddNewBookPage(Model model){
        model.addAttribute("book", new Book());

        return "pages/add-book";
    }

    @PostMapping("/add")
    public String addNewBook(@ModelAttribute("book") Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String getUpdateBookPage(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", bookService.getBookById(id));

        return "pages/edit-book";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book){

        bookService.updateBook(id, book);

        return "redirect:/books";
    }

    @GetMapping("/view/{id}")
    public String getBookDetailsPage(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "pages/book-details";
    }


    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return  "redirect:/books";
    }
}
