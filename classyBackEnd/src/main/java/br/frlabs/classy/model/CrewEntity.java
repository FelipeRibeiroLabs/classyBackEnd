package br.frlabs.classy.model;

import br.frlabs.classy.enums.SchoolYearEnum;
import br.frlabs.classy.enums.UniversityStatusEnum;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "crew")
public class CrewEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

//    @Enumerated(EnumType.STRING)
    private SchoolYearEnum schoolYear;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private UniversityEntity university;

//    @Enumerated(EnumType.STRING)
    private UniversityStatusEnum universityStatus;

    @ManyToOne
    @JoinColumn(name = "esport_id")
    private EsportEntity esport;

    private String logo_url;
    private String instagram;

    @CreationTimestamp
    private LocalDateTime created_at;
}
