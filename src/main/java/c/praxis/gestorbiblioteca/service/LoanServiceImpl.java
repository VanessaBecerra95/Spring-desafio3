package c.praxis.gestorbiblioteca.service;

import c.praxis.gestorbiblioteca.model.dto.Book;
import c.praxis.gestorbiblioteca.model.dto.Loan;
import c.praxis.gestorbiblioteca.model.dto.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private final BookService bookService;
    private final UserService userService;
    private List<Loan> loans = new ArrayList<>();


    public LoanServiceImpl(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @Override
    public void borrowBook(int bookId, int userId) {
        Book book = bookService.findOne(bookId);
        User user = userService.findOne(userId);
        if (book != null && user != null && book.isAvailable()) {
            book.setAvailable(false);
            bookService.update(book);
            user.setIdBook(bookId);
            userService.update(user);
            loans.add(new Loan(loans.size() + 1, userId, bookId, LocalDate.now(), null));
        }
    }

    @Override
    public void returnBook(int bookId, int userId) {
        Book book = bookService.findOne(bookId);
        User user = userService.findOne(userId);
        if (book != null && user != null && user.getIdBook() == bookId) {
            book.setAvailable(true);
            bookService.update(book);
            user.setIdBook(-1);
            userService.update(user);
            for (Loan loan : loans) {
                if (loan.getIdBook() == bookId && loan.getIdUser() == userId && loan.getReturnDate() == null) {
                    loan.setReturnDate(LocalDate.now());
                    break;
                }
            }
        }
    }

    @Override
    public List<Loan> getUserLoanHistory(int userId) {
        List<Loan> userLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getIdUser() == userId) {
                userLoans.add(loan);
            }
        }
        return userLoans;
    }
}
