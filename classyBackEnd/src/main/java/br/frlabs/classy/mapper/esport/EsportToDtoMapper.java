package br.frlabs.classy.mapper.esport;

import br.frlabs.classy.dto.EsportDto;
import br.frlabs.classy.model.EsportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EsportToDtoMapper {

//    @Mapping(target = "plataform", expression = "java( PlataformEnum.getEnum(request.getPlataform() ) )")
    EsportDto toDto(EsportEntity request);
}
