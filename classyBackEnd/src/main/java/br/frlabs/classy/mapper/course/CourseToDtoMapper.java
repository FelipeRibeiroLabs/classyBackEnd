package br.frlabs.classy.mapper.course;

import br.frlabs.classy.dto.CourseDto;
import br.frlabs.classy.model.CourseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseToDtoMapper {

    CourseDto toDto(CourseEntity request);
}
