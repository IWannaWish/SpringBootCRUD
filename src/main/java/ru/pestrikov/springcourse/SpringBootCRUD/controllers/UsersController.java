package ru.pestrikov.springcourse.SpringBootCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pestrikov.springcourse.SpringBootCRUD.model.User;
import ru.pestrikov.springcourse.SpringBootCRUD.service.UserService;


@Controller
@RequestMapping
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getStartPage(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "views/index";
    }

    @GetMapping("/users")
    public String getUserPage(@RequestParam("id") int id, Model model) {
        model.addAttribute("users", userService.show(id));
        return "views/show";
    }

    @GetMapping("/new")
    public String getNewUserPage(Model model) {
        model.addAttribute("user", new User());
        return "views/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:http://localhost:8080/";
    }

    @GetMapping("/edit")
    public String getEditUserPage(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "views/edit";
    }


    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user,
                             @RequestParam("id") int id) {
        userService.update(id, user);
        return "redirect:http://localhost:8080/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") int id) {
        userService.delete(id);
        return "redirect:http://localhost:8080/";
    }
}