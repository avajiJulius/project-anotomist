package edu.anatomist.controller;

import edu.anatomist.domain.User;
import edu.anatomist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        List<User> userList = userService.getUsers();
        model.addAttribute("userList", userList);
        return "home";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/";
    }
}
