package itechart.bookingservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserModel {
    @Id
    private int id;
    private String name;
    private String email;
}
