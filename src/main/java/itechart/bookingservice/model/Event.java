package itechart.bookingservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "events")
public class Event {
    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

/*    @ManyToOne
    @JoinColumn(name="id_place")
    private Place place;*/

    private int categoryId;

    @Column(name = "age_limit")
    private Integer ageLimit;
    @Column(name = "data_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date dateTime;
    @Column
    private String image;

  /*  @OneToMany(mappedBy = "eventId")
    private Set<Ticket> tickets;*/

}
