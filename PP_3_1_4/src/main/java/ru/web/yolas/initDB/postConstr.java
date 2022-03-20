package ru.web.yolas.initDB;

import org.springframework.stereotype.Component;
import ru.web.yolas.models.Role;
import ru.web.yolas.models.User;
import ru.web.yolas.service.RoleService;
import ru.web.yolas.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class postConstr {

    final UserService userService;
    final RoleService roleService;

    public postConstr(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void firstInitDB() {

        roleService.saveRole(new Role("ADMIN"));
        roleService.saveRole(new Role("USER"));

        Set<Role> roleAdmin = new HashSet<>();
        roleAdmin.add(roleService.getRoleByName("ADMIN"));
        Set<Role> roleUser = new HashSet<>();
        roleUser.add(roleService.getRoleByName("USER"));

        User admin = new User();
        admin.setName("admin");
        admin.setSurname("admin");
        admin.setEmail("admin@a");
        admin.setAge(18);
        admin.setPassword("admin");
        admin.setRoles(roleAdmin);
        userService.addUser(admin);

        User user = new User();
        user.setName("user");
        user.setSurname("user");
        user.setEmail("user@u");
        user.setAge(18);
        user.setPassword("user");
        user.setRoles(roleUser);
        userService.addUser(user);

    }
}
