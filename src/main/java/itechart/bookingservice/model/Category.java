package itechart.bookingservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name_category")
    private String name;

/*    @OneToMany(mappedBy = "category_id")
    private Set<Event> events;*/

}
