package vudinhdo.web.travel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "blogs")
public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBlog;
    private String descriptionBlog;
    private String firstImageBlog;
    private String secondImageBlog;
    private String thirdImageBlog;
    private LocalTime timeCreateBlog;
    private LocalTime timeUpdateBlog;
}
