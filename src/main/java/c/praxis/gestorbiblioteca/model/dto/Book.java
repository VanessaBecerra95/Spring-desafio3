package c.praxis.gestorbiblioteca.model.dto;

public class Book {
    private int idBook;
    private String isbn;
    private String title;
    private int autorId;
    private Author author;
    private String extract;
    private boolean available;

    public Book() {
    }

    public Book(int idBook, String isbn, String title, int autorId, String extract, boolean available) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.title = title;
        this.autorId = autorId;
        this.extract = extract;
        this.available = available;
    }

    public Book(int idBook, String isbn, String title, int autorId, Author author, String extract, boolean available) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.title = title;
        this.autorId = autorId;
        this.author = author;
        this.extract = extract;
        this.available = available;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}