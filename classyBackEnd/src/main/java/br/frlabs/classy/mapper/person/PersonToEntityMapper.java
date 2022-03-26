package br.frlabs.classy.mapper.person;

import br.frlabs.classy.dto.PersonDto;
import br.frlabs.classy.model.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonToEntityMapper {

//    @Mapping(target = "crew.name", source = "request.crewName")
//    @Mapping(target = "crew.school.schoolName", source = "request.crewSchool")
//    @Mapping(target = "crew.university.universityName", source = "request.crewUniversity")
//    @Mapping(target = "crew.esport.gameName", source = "request.crewGame")

    PersonEntity toEntity(PersonDto request);
}
