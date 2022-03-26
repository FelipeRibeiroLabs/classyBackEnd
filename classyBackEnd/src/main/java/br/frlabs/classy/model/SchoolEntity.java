package br.frlabs.classy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "school")
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolName;
    private String city;
    private String state;
}
