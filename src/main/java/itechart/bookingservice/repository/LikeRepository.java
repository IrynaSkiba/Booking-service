package itechart.bookingservice.repository;

import itechart.bookingservice.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like,Integer> {
    Like findByEventIdAndUserId(int eventId, int userId);
}
