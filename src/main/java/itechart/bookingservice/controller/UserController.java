package itechart.bookingservice.controller;

import itechart.bookingservice.repository.UserRepository;
import itechart.bookingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @GetMapping("users/{id}")
    public String getUser(){
        return "/{id}";
    }

    @GetMapping("users")
    public String getUsers(){
        return "users";
    }
}
