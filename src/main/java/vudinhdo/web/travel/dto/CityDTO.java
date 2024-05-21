package vudinhdo.web.travel.dto;

import jakarta.persistence.OneToMany;
import lombok.Data;
import vudinhdo.web.travel.model.Tours;

import java.time.LocalTime;
import java.util.List;

@Data
public class CityDTO {
    private Integer id;
    private String nameCity;
    private String avatarCity;
    private String descriptionCity;
    private LocalTime timeCreate;
    private LocalTime timeUpdate;
    private List<Tours> tours;
}
