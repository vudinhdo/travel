package vudinhdo.web.travel.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import vudinhdo.web.travel.model.Accounts;
import vudinhdo.web.travel.model.Tours;

import java.time.LocalDate;

@Data
public class BookingDTO {
    private int id;
    private Integer tour_id;
    private Integer account_id;
    private LocalDate dateBooking;
    private Integer numberPeople;
}
