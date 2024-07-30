package c.praxis.gestorbiblioteca.service;

import c.praxis.gestorbiblioteca.model.dto.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);

    public AuthorServiceImpl(List<Author> authorList) {
        this.authorList = authorList;
    }

    private List<Author> authorList;

    public AuthorServiceImpl() {
        authorList = new ArrayList<>();
        authorList.add(new Author(101, "F. Scott", "Fitzgerald", 1896));
        authorList.add(new Author(102, "Harper", "Lee", 1926));
        authorList.add(new Author(103, "George", "Orwell", 1903));
        authorList.add(new Author(104, "Jane", "Austen", 1775));
        authorList.add(new Author(105, "J.D.", "Salinger", 1919));
        authorList.add(new Author(106, "Herman", "Melville", 1819));
    }


    @Override
    public List<Author> findAll() {
        logger.warn("Ejecutando findAll de AuthorServiceImpl");
        return authorList;
    }

    @Override
    public Author findOne(int id) {
        return authorList.stream()
                .filter(author -> author.getIdAuthor() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean create(Author b) {
        return false;
    }

    @Override
    public boolean update(Author b) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
