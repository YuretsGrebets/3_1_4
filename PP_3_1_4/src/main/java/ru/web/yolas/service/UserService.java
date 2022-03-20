package ru.web.yolas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.web.yolas.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void addUser(User user);

    void removeUser(int id);

    void updateUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    User findByUsername(String username);
}
