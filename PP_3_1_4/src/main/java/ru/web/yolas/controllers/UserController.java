package ru.web.yolas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.web.yolas.service.UserService;

import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;


    @Autowired()
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public String pageForUser (Model model, Principal principal) {
        model.addAttribute("MainUser",userService.loadUserByUsername(principal.getName()));
        return "user/user-page";
    }
}