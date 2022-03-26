package br.frlabs.classy.mapper.school;

import br.frlabs.classy.dto.SchoolDto;
import br.frlabs.classy.model.SchoolEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolToEntityMapper {

    SchoolEntity toEntity(SchoolDto request);
}
