package br.frlabs.classy.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PersonDto {

    @NotBlank(message = "O nome precisa ter mais de 3 caracteres") @Size(min = 3)
    private String name;
    @NotBlank(message = "O nickname precisa ter mais de 3 caracteres") @Size(min = 3)
    private String nickname;

    private String phoneNumber;
    @NotBlank(message = "O email precisa ser preenchido!")
    private String email;
    private int number;
//
//    private String crewName;
//    private String crewSchool;
//    private String crewUniversity;
//    private String crewGame;
}
