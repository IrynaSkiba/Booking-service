package itechart.bookingservice.model;

import itechart.bookingservice.dto.EventDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "events")
public class Event {
    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "age_limit")
    private Integer ageLimit;
    @Column(name = "data_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date dateTime;
    @Column
    private String image;
    @Column
    private String name;

    private int categoryId;
    private int placeId;

    @OneToMany(mappedBy = "eventId",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Comment> comments;
    @OneToMany(mappedBy = "eventId",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Like> likes;
    @OneToMany(mappedBy = "eventId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    public Event(EventDto event) {
        this.setDateTime(event.getDateTime());
        this.setAgeLimit(event.getAgeLimit());
        this.setImage(event.getImage());
        this.setName(event.getName());
        this.setPlaceId(event.getPlaceId());
        this.setCategoryId(event.getCategoryId());
    }

    public Event(){

    }
}
