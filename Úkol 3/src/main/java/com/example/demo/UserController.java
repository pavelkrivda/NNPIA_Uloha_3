package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public String requestGreeting(
            @RequestParam(name = "firstname", required = false, defaultValue = "") String firstname,
            @RequestParam(name = "lastName", required = false, defaultValue = "") String lastName,
            @RequestParam(name = "age", required = false, defaultValue = "0") String age,
            @RequestParam(name = "weight", required = false, defaultValue = "0") String weight,
            Model model) {

        int userAge = Integer.parseInt(age);
        float userWeight = Float.parseFloat(weight);
        User user = new User(firstname, lastName, userAge, userWeight);
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("/user")
    public String greetingSubmit(@ModelAttribute User user, Model model) {

        userService.addUser(user);
        model.addAttribute("user", user);
        return "result";
    }

    @GetMapping(value = "/user/{lastname}")
    public String requestWelcome(@PathVariable(name = "lastname", required = false) String lastname, Model model) {

        List<User> users = userService.getUsers();
        model.addAttribute("users", users.stream().filter(user -> user.getLastName().equals(lastname)).collect(Collectors.toList()));
        return "allUsers";
    }
}