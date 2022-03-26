package br.frlabs.classy.mapper.person;

import br.frlabs.classy.dto.PersonDto;
import br.frlabs.classy.model.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonToDtoMapper {

//    @Mapping(target = "request.crewName", source = "crew.name")
//    @Mapping(target = "request.crewSchool", source = "crew.school.schoolName")
//    @Mapping(target = "request.crewUniversity", source = "crew.university.universityName")
//    @Mapping(target = "request.crewGame", source = "crew.esport.gameName")
    PersonDto toDto(PersonEntity request);
}
