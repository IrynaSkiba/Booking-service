package itechart.bookingservice.repository;

import itechart.bookingservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends  JpaRepository<User, String> {
    User findByEmail(String email);
}
