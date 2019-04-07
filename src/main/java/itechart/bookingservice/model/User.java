package itechart.bookingservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column(name = "is_admin")
    private boolean isAdmin;
    @Column
    private String city;

    @OneToMany(mappedBy = "userId")
    private Set<Comment> comments;
    @OneToMany(mappedBy = "userId")
    private Set<Like> likes;
    @OneToMany(mappedBy = "userId")
    private Set<Ticket> tickets;
}
