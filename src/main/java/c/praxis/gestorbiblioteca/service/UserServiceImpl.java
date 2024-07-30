package c.praxis.gestorbiblioteca.service;

import c.praxis.gestorbiblioteca.model.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> userList;

    public UserServiceImpl() {
        userList = new ArrayList<>();
        userList.add(new User(1, "John", "Doe", "john.doe@example.com", "123 Main St", "123-456-7890", -1));
        userList.add(new User(2, "Jane", "Smith", "jane.smith@example.com", "456 Elm St", "987-654-3210", -1));
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public User findOne(int idUser) {
        return userList.stream().filter(user -> user.getIdUser() == idUser).findFirst().orElse(null);
    }

    @Override
    public boolean create(User user) {
        userList.add(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        User existingUser = findOne(user.getIdUser());
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setAddress(user.getAddress());
            existingUser.setPhone(user.getPhone());
            existingUser.setIdBook(user.getIdBook());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int idUser) {
        return userList.removeIf(user -> user.getIdUser() == idUser);
    }
}
