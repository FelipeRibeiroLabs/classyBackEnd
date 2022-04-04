package br.frlabs.classy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;


    @ManyToOne
    @JoinColumn(name = "university_id")
    private UniversityEntity university;
}
