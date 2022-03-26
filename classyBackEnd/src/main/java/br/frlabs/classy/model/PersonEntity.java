package br.frlabs.classy.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "crew_id")
    private CrewEntity crew;

    @CreationTimestamp
    private LocalDateTime created_at;
}
