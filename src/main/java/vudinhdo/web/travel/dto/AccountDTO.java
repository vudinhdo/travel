package vudinhdo.web.travel.dto;

import jakarta.persistence.OneToMany;
import lombok.Data;
import vudinhdo.web.travel.model.Booking;

import java.time.LocalTime;
import java.util.List;

@Data
public class AccountDTO {
    private Integer id;
    private String username;
    private String fullName;
    private String password;
    private String email;
    private String phoneNumber;
    private LocalTime timeCreate;
    private LocalTime timeUpdate;
    private List<Booking> bookings;
}
