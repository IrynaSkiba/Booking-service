package itechart.bookingservice.controller;

import itechart.bookingservice.model.User;
import itechart.bookingservice.repository.UserRepository;
import itechart.bookingservice.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserRepository userRepository;
    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("users/{id}")
    public User getUser(@PathVariable("id") User user) {
        return user;
    }

    @GetMapping("users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("users")
    @PreAuthorize("hasRole('ADMIN')")
    public String createAdmin(@RequestBody User user){
        if (userRepository.findByEmail(user.getEmail()) != null)  return "redirect: users";
        userService.saveAdmin(user);
        return "redirect:";
    }
}
