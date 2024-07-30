package c.praxis.gestorbiblioteca.service;

import c.praxis.gestorbiblioteca.model.dto.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private List<Book> bookList;

    private AuthorService authorService = new AuthorServiceImpl();

    public BookServiceImpl() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1, "978-3-16-148410-0", "The Great Gatsby", 101, authorService.findOne(101), "A story about the mysterious millionaire Jay Gatsby and his obsession with the beautiful Daisy Buchanan.", true));
        bookList.add(new Book(2, "978-1-56619-909-4", "To Kill a Mockingbird", 102, authorService.findOne(102), "A novel set in the 1930s deep South, focusing on the moral growth of its young narrator, Scout Finch.", true));
        bookList.add(new Book(3, "978-0-7432-7356-5", "1984", 103, authorService.findOne(103), "A dystopian social science fiction novel and cautionary tale about the dangers of totalitarianism.", true));
        bookList.add(new Book(4, "978-0-452-28423-4", "Pride and Prejudice",  104, authorService.findOne(104), "A romantic novel that charts the emotional development of the protagonist, Elizabeth Bennet.", true));
        bookList.add(new Book(5, "978-0-553-21311-7", "The Catcher in the Rye", 105, authorService.findOne(105), "A story about a few days in the life of a troubled teenager, Holden Caulfield, who has been expelled from prep school.", true));
        bookList.add(new Book(6, "978-0-14-028329-7", "Moby-Dick", 106, authorService.findOne(106), "The narrative of Captain Ahab’s obsessive quest to seek revenge on Moby Dick, the giant white sperm whale.", true));
    }

    @Override
    public List<Book> findAll() {
        return bookList;
    }

    @Override
    public Book findOne(int id) {
        return bookList.stream().filter(book -> book.getIdBook() == id).findFirst().orElse(null);
    }

    @Override
    public boolean create(Book book) {
        return bookList.add(book);
    }

    @Override
    public boolean update(Book book) {
        Book existingBook = findOne(book.getIdBook());
        if (existingBook != null) {
            existingBook.setIsbn(book.getIsbn());
            existingBook.setTitle(book.getTitle());
            existingBook.setAutorId(book.getAutorId());
            existingBook.setExtract(book.getExtract());
            existingBook.setAvailable(book.isAvailable());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return bookList.removeIf(book -> book.getIdBook() == id);
    }

    @Override
    public List<Book> search(String query) {
        return bookList.stream()
                .filter(book ->
                        (book.getAuthor() != null &&
                                (book.getAuthor().getName().toLowerCase().contains(query.toLowerCase()) ||
                                        book.getAuthor().getLastname().toLowerCase().contains(query.toLowerCase()))) ||
                                book.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAvailableBooks() {
        return bookList.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }
}