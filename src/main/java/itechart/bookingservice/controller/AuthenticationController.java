package itechart.bookingservice.controller;

import itechart.bookingservice.model.User;
import itechart.bookingservice.repository.UserRepository;
import itechart.bookingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration")
    public String addUser(@RequestBody User user) {
        if (userService.findByEmail(user.getEmail()) != null) return "registration";
        userService.saveUser(user);
        return "redirect:";
    }
}
