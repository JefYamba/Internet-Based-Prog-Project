package cg.jefy.IBPProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: JefYamba
 */

@Controller
public class TestController {


    @GetMapping("/getLoginPage")
    public String getLoginPage(){

        return "login";
    }

    @GetMapping("/getLayoutPage")
    public String getLayoutPage(){

        return "layout/_layout";
    }

    @GetMapping("/getHomePage")
    public String getHomePage(){

        return "pages/home";
    }
    @GetMapping("/getUsersPage")
    public String getUsersPage(){

        return "pages/users";
    }

    @GetMapping("/getBooksPage")
    public String getBooksPage(){

        return "pages/books";
    }

    @GetMapping("/getEditUserPage")
    public String getEditUserPage(){

        return "pages/edit-user";
    }
    @GetMapping("/getEditBookPage")
    public String getEditBookPage(){

        return "pages/edit-book";
    }
    @GetMapping("/getBookDetailsPage")
    public String getBookDetailsPage(){

        return "pages/book-details";
    }
}
