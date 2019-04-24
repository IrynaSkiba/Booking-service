package itechart.bookingservice.service.impl;

import itechart.bookingservice.model.Like;
import itechart.bookingservice.repository.LikeRepository;
import itechart.bookingservice.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public void setLike(boolean isLike, int userId, int eventId) {
        Like like = likeRepository.findByEventIdAndUserId(eventId, userId);
        if (like != null){
            like.setLike(isLike);
            return;
        }
        like = new Like(isLike, userId, eventId);
        likeRepository.save(like);
    }
}
