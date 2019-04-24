package itechart.bookingservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "likes")
public class Like {
    @Id
    @Column(name = "like_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "is_like")
    private boolean isLike;

    private int userId;
    private int eventId;

    public Like(boolean isLike, int userId, int eventId){
        this.setLike(isLike);
        this.setUserId(userId);
        this.setEventId(eventId);
    }
    public Like(){
    }
}
