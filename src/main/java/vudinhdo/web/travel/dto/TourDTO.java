package vudinhdo.web.travel.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import vudinhdo.web.travel.model.Cities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class TourDTO {
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
    private Integer city_id;
}
