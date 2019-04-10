package itechart.bookingservice.controller;

import itechart.bookingservice.model.User;
import itechart.bookingservice.repository.UserRepository;
import itechart.bookingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("users/{id}")
    public User getUser(@PathVariable("id") User user) {
        return user;
    }

    @GetMapping("users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("users")
    @PreAuthorize("hasRole('ADMIN')")
    public String createAdmin(@RequestBody User user){
        if (userService.findByEmail(user.getEmail()) != null)  return "redirect: users";
        userService.saveAdmin(user);
        return "redirect:";
    }
}
