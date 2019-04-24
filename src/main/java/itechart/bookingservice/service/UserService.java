package itechart.bookingservice.service;

import itechart.bookingservice.model.Comment;
import itechart.bookingservice.model.Like;
import itechart.bookingservice.model.User;

import java.security.Principal;
import java.util.List;
import java.util.Set;

public interface UserService {
    void saveUser(User user);
    void saveAdmin(User user);

    List<User> getUsers();

    User findByEmail(String email);
    int getIdOfCurrentUser(Principal currentUser);
    Set<Like> getLikes(Principal currentUser);
    Set<Comment> getComments(Principal currentUser);
}
