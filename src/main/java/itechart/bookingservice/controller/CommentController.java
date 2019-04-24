package itechart.bookingservice.controller;

import itechart.bookingservice.model.Comment;
import itechart.bookingservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Set;

@RestController
public class CommentController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("comments")
    public Set<Comment> getComments(Principal currentUser){
        return userService.getComments(currentUser);
    }
}
