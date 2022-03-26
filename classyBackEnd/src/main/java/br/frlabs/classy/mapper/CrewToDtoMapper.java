package br.frlabs.classy.mapper;

import br.frlabs.classy.dto.CrewDto;
import br.frlabs.classy.enums.PlataformEnum;
import br.frlabs.classy.enums.SchoolYearEnum;
import br.frlabs.classy.enums.UniversityStatusEnum;
import br.frlabs.classy.model.CrewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {SchoolYearEnum.class, UniversityStatusEnum.class, PlataformEnum.class})
public interface CrewToDtoMapper {

    @Mapping(target = "schoolId", source = "request.school.id")
    @Mapping(target = "schoolName", source = "request.school.schoolName")
    @Mapping(target = "schoolYear", source = "request.schoolYear")

    @Mapping(target = "universityId", source = "request.university.id")
    @Mapping(target = "universityName", source = "request.university.universityName")
    @Mapping(target = "universityStatus", source = "request.universityStatus")

    @Mapping(target = "gameId", source = "request.esport.id")

    CrewDto toDto(CrewEntity request);
}