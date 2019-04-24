package itechart.bookingservice.service.impl;

import itechart.bookingservice.model.User;
import itechart.bookingservice.repository.UserRepository;
import itechart.bookingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void saveUser(User userDto) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setAdmin(false);
        user.setBirthday(userDto.getBirthday());
        user.setCity(userDto.getCity());
        userRepository.save(user);
    }

    @Override
    public void saveAdmin(User user) {
        User admin = new User();
        admin.setPassword(passwordEncoder.encode(user.getPassword()));
        admin.setEmail(user.getEmail());
        admin.setName(user.getName());
        admin.setAdmin(true);
        admin.setBirthday(user.getBirthday());
        admin.setCity(user.getCity());
        userRepository.save(admin);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public int getIdOfCurrentUser(Principal currentUser){
        return findByEmail(currentUser.getName()).getId();
    }
}
