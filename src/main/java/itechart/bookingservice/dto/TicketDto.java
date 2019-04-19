package itechart.bookingservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TicketDto {
    private BigDecimal price;
}
