package br.frlabs.classy.mapper.esport;

import br.frlabs.classy.dto.EsportDto;
import br.frlabs.classy.model.EsportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EsportToEntityMapper {

//    @Mapping(target = "plataform", expression = "java( PlataformEnum.getEnum(request.getPlataform() ) )")

    EsportEntity toEntity(EsportDto request);
}
