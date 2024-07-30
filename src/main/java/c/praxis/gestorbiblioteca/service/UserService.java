package c.praxis.gestorbiblioteca.service;

import c.praxis.gestorbiblioteca.model.dto.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findOne(int idUser);
    boolean create(User user);
    boolean update(User user);
    boolean delete(int idUser);
}
