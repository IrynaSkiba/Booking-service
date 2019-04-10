package itechart.bookingservice.service;

import itechart.bookingservice.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void saveAdmin(User user);

    List<User> getUsers();

    User findByEmail(String email);
}
