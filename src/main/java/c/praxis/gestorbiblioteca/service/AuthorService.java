package c.praxis.gestorbiblioteca.service;

import c.praxis.gestorbiblioteca.model.dto.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findOne(int id);
    boolean create(Author b);
    boolean update(Author b);
    boolean delete(int id);
}