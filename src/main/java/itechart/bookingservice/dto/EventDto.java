package itechart.bookingservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EventDto {
    private Integer ageLimit;
    private Date dateTime;
    private String image;
    private String name;
    private int categoryId;
    private int placeId;
    private BigDecimal price;
}
