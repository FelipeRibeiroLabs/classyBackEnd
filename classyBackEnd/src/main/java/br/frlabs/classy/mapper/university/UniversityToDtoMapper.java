package br.frlabs.classy.mapper.university;

import br.frlabs.classy.dto.UniversityDto;
import br.frlabs.classy.model.UniversityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniversityToDtoMapper {

    UniversityDto toDto(UniversityEntity request);
}
