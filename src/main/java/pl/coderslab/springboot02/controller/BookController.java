package pl.coderslab.springboot02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot02.entity.Book;
import pl.coderslab.springboot02.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String list(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        return "form";
    }

    @PostMapping("/form")
    public String add(Book book, Model model) {
        // model.addAttribute("book", book);
        bookService.add(book);
        return "redirect:/book";
    }
    //    @GetMapping("/{id}")

    //    @ResponseBody
//    public String rating(@PathVariable Long id, Model model) {
//        Book book = bookService.findById(id);
////        model.addAttribute("books", books);
//        return book.toString();
//    }
    @GetMapping("/form/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        //   bookService.update(id);
        model.addAttribute(book);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String removeBook(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/book";
    }
}