package br.frlabs.classy.model;

import br.frlabs.classy.enums.SchoolYearEnum;
import br.frlabs.classy.enums.UniversityStatusEnum;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "crew")
public class CrewEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Não pode estar vazio")
    @NotNull(message = "Não pode ser nulo")
    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    @Enumerated(EnumType.STRING)
    private SchoolYearEnum schoolYear;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private UniversityEntity university;

    @Enumerated(EnumType.STRING)
    private UniversityStatusEnum universityStatus;

    @ManyToOne
    @JoinColumn(name = "esport_id")
    private EsportEntity esport;

    @ManyToMany
    @JoinTable(
            name = "crew_person",
            uniqueConstraints = @UniqueConstraint(columnNames = {"person_id", "crew_id"}),
            joinColumns = {@JoinColumn(name = "crew_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")}
    )
    private List<PersonEntity> persons;

    @ManyToMany
    @JoinTable(
            name = "admin",
            uniqueConstraints = @UniqueConstraint(columnNames = {"person_id", "crew_id"}),
            joinColumns = {@JoinColumn(name = "crew_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")}
    )
    private List<PersonEntity> admPerson;

    private String logo_url;
    private String instagram;

    @CreationTimestamp
    private LocalDateTime created_at;
}
