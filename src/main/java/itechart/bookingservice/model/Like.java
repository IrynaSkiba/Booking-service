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
    /*    @Column(name = "id_user")
        private Integer user;
        @Column(name = "id_event")
        private Integer event;*/
    @Column(name = "is_like")
    private Boolean isLike;
}
