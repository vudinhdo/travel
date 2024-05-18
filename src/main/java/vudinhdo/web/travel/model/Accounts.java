package vudinhdo.web.travel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String fullName;
    private String password;
    private String email;
    private String phoneNumber;
    private LocalTime timeCreate;
    private LocalTime timeUpdate;
}
