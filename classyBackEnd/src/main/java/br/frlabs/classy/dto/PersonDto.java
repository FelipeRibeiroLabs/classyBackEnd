package br.frlabs.classy.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PersonDto {

    @NotBlank
    private String name;
    @NotBlank
    private String nickname;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
    private int number;
//
//    private String crewName;
//    private String crewSchool;
//    private String crewUniversity;
//    private String crewGame;
}
