package br.frlabs.classy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nickname;
    private String phoneNumber;
    private String email;
    private int number;

    @ManyToMany()
    @JsonIgnore
    @JoinTable(
             name = "crew_person",
            uniqueConstraints = @UniqueConstraint(columnNames = {"person_id", "crew_id"}),
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "crew_id")}
    )
    private List<CrewEntity> crews;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "admin",
            uniqueConstraints = @UniqueConstraint(columnNames = {"person_id", "crew_id"}),
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "crew_id")}
    )
    private List<CrewEntity> admCrew;

    @CreationTimestamp
    private LocalDateTime created_at;
}
