package ru.web.yolas.repositories;

import org.springframework.stereotype.Repository;
import ru.web.yolas.models.User;

import java.util.List;

public interface UserRepository  {
    void addUser(User user);

    void removeUser(int id);

    void editUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    User getUserByUsername(String username);
}
