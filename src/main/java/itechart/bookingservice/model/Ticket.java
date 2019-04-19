package itechart.bookingservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private BigDecimal price;

    private int eventId;
    private int userId;

    public Ticket(int eventId, BigDecimal price){
        this.setPrice(price);
        this.setEventId(eventId);
    }

    public Ticket(){}
}
