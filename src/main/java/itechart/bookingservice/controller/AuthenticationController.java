package itechart.bookingservice.controller;

import itechart.bookingservice.model.User;
import itechart.bookingservice.repository.UserRepository;
import itechart.bookingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/login";    //Here need Oauth2 link
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user, Model model) {
        if(userRepository.findByEmail(user.getEmail()) != null) return "registration";
        userService.saveUser(user);
        return "redirect:/login";
    }
}
