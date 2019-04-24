package itechart.bookingservice.service.impl;

import itechart.bookingservice.model.Comment;
import itechart.bookingservice.repository.CommentRepository;
import itechart.bookingservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public void addComment(String text, int userId, int eventId) {
        Date date = new Date();
        Comment comment = new Comment(text, userId, eventId, date);
        commentRepository.save(comment);
    }
}
