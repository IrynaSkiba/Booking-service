package itechart.bookingservice.controller;

import itechart.bookingservice.model.User;
import itechart.bookingservice.repository.UserRepository;
import itechart.bookingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping(value = "/registration")
    public String addUser(@RequestBody User user, Model model) {
        if (userRepository.findByEmail(user.getEmail()) != null) return "registration";
        userService.saveUser(user);
        return "redirect:/login";
    }
}
