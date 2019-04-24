package itechart.bookingservice.service;

public interface CommentService {
    void addComment(String text, int userId, int eventId);
}
