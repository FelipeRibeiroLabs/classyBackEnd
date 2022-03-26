package br.frlabs.classy.model;

import br.frlabs.classy.enums.UniformTypeEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "uniform")
public class UniformEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UniformTypeEnum type;
    private String uniform_url;

    //private PersonEntity creator;

    @ManyToOne
    @JoinColumn(name = "crew_id")
    private CrewEntity crew;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    private int votesYes;
    private int votesNo;
}
