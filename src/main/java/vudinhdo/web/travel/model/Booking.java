package vudinhdo.web.travel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tours tours;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Accounts accounts;

    private LocalDate dateBooking;
    private Integer numberPeople;
    private String note;
}
