package itechart.bookingservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "places")
public class Place {
    @Id
    @Column(name = "place_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name_place")
    private String name;
    @Column
    private String address;

/*    @OneToMany(mappedBy = "places")
    private Set<Event> events;*/

}
