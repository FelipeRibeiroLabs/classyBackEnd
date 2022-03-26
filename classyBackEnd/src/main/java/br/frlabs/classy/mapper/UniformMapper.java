package br.frlabs.classy.mapper;

import br.frlabs.classy.dto.UniformDto;
import br.frlabs.classy.model.UniformEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniformMapper {

//    @Mapping(target = "crew.name", source = "request.crewName")
//    @Mapping(target = "crew.school.schoolName", source = "request.crewSchool")
//    @Mapping(target = "crew.university.universityName", source = "request.crewUniversity")
//    @Mapping(target = "crew.esport.gameName", source = "request.crewGame")

    UniformEntity toEntity(UniformDto request);
}
