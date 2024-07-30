package c.praxis.gestorbiblioteca.controller;

import c.praxis.gestorbiblioteca.service.BookService;
import c.praxis.gestorbiblioteca.service.LoanService;
import c.praxis.gestorbiblioteca.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loans")
public class LoanController {
    private final LoanService loanService;
    private final BookService bookService;
    private final UserService userService;

    public LoanController(LoanService loanService, BookService bookService, UserService userService) {
        this.loanService = loanService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/borrow")
    public String showBorrowForm(Model model) {
        model.addAttribute("books", bookService.findAvailableBooks());
        model.addAttribute("users", userService.findAll());
        return "borrowBook";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam("bookId") int bookId, @RequestParam("userId") int userId, Model model) {
        loanService.borrowBook(bookId, userId);
        model.addAttribute("message", "El proceso de préstamo se ha realizado correctamente");
        return "redirect:/books";
    }

    @GetMapping("/return")
    public String returnBookForm(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("users", userService.findAll());
        return "returnBook";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("bookId") int bookId, @RequestParam("userId") int userId, Model model) {
        loanService.returnBook(bookId, userId);
        model.addAttribute("message", "El proceso de devolución se ha realizado correctamente");
        return "redirect:/books";
    }

    @GetMapping("/history")
    public String showLoanHistory(@RequestParam(value = "userId", required = false) Integer userId, Model model) {
        if (userId != null) {
            model.addAttribute("loans", loanService.getUserLoanHistory(userId));
        } else {
            model.addAttribute("users", userService.findAll());
        }
        return "userHistory";
    }
}
