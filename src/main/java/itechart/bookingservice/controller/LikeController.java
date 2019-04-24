package itechart.bookingservice.controller;

import itechart.bookingservice.model.Like;
import itechart.bookingservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Set;

@RestController
public class LikeController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("likes")
    public Set<Like> getLikes(Principal currentUser){
        return userService.getLikes(currentUser);
    }
}
