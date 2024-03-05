package cg.jefy.IBPProject.controllers;

import cg.jefy.IBPProject.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: JefYamba
 */
@Controller
@AllArgsConstructor
public class MainController {

    private final BookService bookService;
    @GetMapping("/login")
    public String getLogin(){

        return "login";
    }

    @GetMapping({"/","/home"})
    public String getHomePage(Model model){
        model.addAttribute("books", bookService.getAllBooks());

        return "pages/home";
    }
}
