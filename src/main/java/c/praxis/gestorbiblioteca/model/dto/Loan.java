package c.praxis.gestorbiblioteca.model.dto;

import java.time.LocalDate;

public class Loan {
    private int idLoan;
    private int idUser;
    private int idBook;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan() {
    }

    public Loan(int idLoan, int idUser, int idBook, LocalDate loanDate, LocalDate returnDate) {
        this.idLoan = idLoan;
        this.idUser = idUser;
        this.idBook = idBook;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public int getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(int idLoan) {
        this.idLoan = idLoan;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
