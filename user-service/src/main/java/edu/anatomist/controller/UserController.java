package edu.anatomist.controller;

import edu.anatomist.domain.User;
import edu.anatomist.service.UserService;
import edu.anatomist.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class UserController {

    private final UserService userService;

    @Value("${upload.path}")
    private String uploadPath;

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
        return "add";
    }

    @PostMapping("/saveUser")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("userPhoto")MultipartFile userPhoto, Model model) throws IOException {

        User user = new User();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        if(userPhoto != null) {
            File uploadDir = new File(uploadPath);

            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidPhoto = UUID.randomUUID().toString();
            String userPhotoName = uuidPhoto + "." + userPhoto.getOriginalFilename();

            userPhoto.transferTo(new File(uploadPath + "/" + userPhotoName));
            user.setUserPhoto(userPhotoName);
        }

        userService.saveUser(user);
        model.addAttribute("user", user);

        return "redirect:/";
    }

    @GetMapping("/show/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);

        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);

        return "redirect:/";
    }
}
