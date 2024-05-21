package vudinhdo.web.travel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "tours")
public class Tours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameTour;
    private String tourCode;
    private String imageTourOne;
    private String imageTourTwo;
    private String imageTourThree;
    private Integer priceTour;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime timeCreate;
    private LocalTime timeUpdate;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private Cities cities;




}
