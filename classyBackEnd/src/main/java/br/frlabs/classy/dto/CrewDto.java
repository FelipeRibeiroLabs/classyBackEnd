package br.frlabs.classy.dto;

import lombok.Data;

@Data
public class CrewDto {

    private String name;

    private Long schoolId;
    private String schoolName;
    private String schoolYear;

    private Long universityId;
    private String universityName;
    private String universityStatus;

    private Long gameId;
    private String plataform;

    private String logo_url;
    private String instagram;
}
