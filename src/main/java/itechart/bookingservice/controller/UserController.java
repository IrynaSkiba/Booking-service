package itechart.bookingservice.controller;

import itechart.bookingservice.repository.UserRepository;
import itechart.bookingservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserRepository userRepository;

    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("users/{id}")
    public String getUser() {
        return "/{id}";
    }

    @GetMapping("users")
    public String getUsers() {
        return "users";
    }
}
