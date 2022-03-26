package br.frlabs.classy.model;

import br.frlabs.classy.enums.PlataformEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "esport")
public class EsportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gameName;

    private PlataformEnum plataform;
}
