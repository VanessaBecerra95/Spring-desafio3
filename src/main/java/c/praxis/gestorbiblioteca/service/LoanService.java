package c.praxis.gestorbiblioteca.service;

import c.praxis.gestorbiblioteca.model.dto.Loan;

import java.util.List;

public interface LoanService
{
    void borrowBook(int bookId, int userId);
    void returnBook(int bookId, int userId);
    List<Loan> getUserLoanHistory(int userId);
}
