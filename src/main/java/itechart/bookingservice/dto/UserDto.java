package itechart.bookingservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private int id;
    private String name;
    private String email;
    private char[] password;
    private boolean isAdmin;
}
