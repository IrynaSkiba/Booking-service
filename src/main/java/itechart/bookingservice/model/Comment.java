package itechart.bookingservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /*    @Column
        private Integer user;
        @Column
        private Integer event;*/
    @Column(name = "data_time")
    private Date dataTime;
    @Column
    private String text;
}
