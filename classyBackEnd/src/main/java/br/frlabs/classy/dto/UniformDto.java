package br.frlabs.classy.dto;

import lombok.Data;

@Data
public class UniformDto {

    private String type;
    private String uniform_url;

    private Long crewId;

    private Long personId;

    //Utilizar no request apenas?
//    private String crewSchool;
//    private String crewUniversity;
//    private String crewGame;

    private int votesYes;
    private int votesNo;
}
