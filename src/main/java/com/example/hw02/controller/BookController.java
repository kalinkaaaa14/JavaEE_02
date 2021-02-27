package com.example.hw02.controller;
import com.example.hw02.model.Book;
import com.example.hw02.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String getMain(Model model) {
        model.addAttribute("books", bookService.returnAllBooks());
        return "main";
    }

    @GetMapping("/add-book")
    public String addBookGet(Model model) {
        model.addAttribute("newBook", new Book());
        return "add-book";
    }

    @PostMapping("/add-book")
    public String addBookPost(
            @ModelAttribute("newBook") Book newBook, Model model) {
        model.addAttribute("newBook", newBook);
       String page = this.bookService.createNewBook(newBook);
       if(page.equals("main")) {
           return "redirect:/";
       }else{
         return "redirect:/error-page";
       }
    }

    @GetMapping("/error-page")
    public String getErrorPage(Model model) {
        model.addAttribute("error", "The book with such ISBN already exists. It should be unique. Try again.");
        return "error-page";
    }
}
