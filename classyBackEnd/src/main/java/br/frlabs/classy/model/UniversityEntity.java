package br.frlabs.classy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "university")
public class UniversityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String universityName;
    private String city;
    private String state;
}
