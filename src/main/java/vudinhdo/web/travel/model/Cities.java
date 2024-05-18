package vudinhdo.web.travel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "cities")
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameCity;
    private String avatarCity;
    private String descriptionCity;
    private LocalTime timeCreate;
    private LocalTime timeUpdate;
    @OneToMany(mappedBy = "cities")
    private List<Tours> tours;

}
