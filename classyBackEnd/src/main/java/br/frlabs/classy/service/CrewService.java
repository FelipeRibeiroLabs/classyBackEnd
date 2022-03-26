package br.frlabs.classy.service;

import br.frlabs.classy.dto.CrewDto;
import br.frlabs.classy.enums.SchoolYearEnum;
import br.frlabs.classy.enums.UniversityStatusEnum;
import br.frlabs.classy.mapper.CrewToDtoMapper;
import br.frlabs.classy.model.CrewEntity;
import br.frlabs.classy.model.EsportEntity;
import br.frlabs.classy.model.UniversityEntity;
import br.frlabs.classy.repository.CrewRepository;
import br.frlabs.classy.repository.EsportRepository;
import br.frlabs.classy.repository.SchoolRepository;
import br.frlabs.classy.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrewService {

    private final CrewRepository crewRepository;
    private final SchoolRepository schoolRepository;
    private final UniversityRepository universityRepository;
    private final EsportRepository esportRepository;
    private final CrewToDtoMapper mapperToDto;

    public CrewDto createCrew(CrewDto request) {
        CrewEntity crewEntity = new CrewEntity();
        UniversityEntity university = new UniversityEntity();
        EsportEntity esport = new EsportEntity();

        if(request.getSchoolId() != null) {
            crewEntity.setSchool(schoolRepository.getById(request.getSchoolId()));
        }

        if(request.getUniversityId() != null) {
            crewEntity.setUniversity(universityRepository.getById(request.getUniversityId()));
        }

        if(request.getGameId() != null) {
            crewEntity.setEsport(esportRepository.getById(request.getGameId()));
        }

        crewEntity.setName(request.getName());
        crewEntity.setLogo_url(request.getLogo_url());
        crewEntity.setInstagram(request.getInstagram());

        crewEntity.setSchoolYear(SchoolYearEnum.getEnum(request.getSchoolYear()));

        crewEntity.setUniversityStatus(UniversityStatusEnum.getEnum(request.getUniversityStatus()));


        crewRepository.save(crewEntity);
        return request;
    }

    //TODO -> REFACTOR -> ALTERAR O ATRIBUTO DE ID PARA CREWENTITY?
    public CrewDto updateCrew(CrewDto request, Long id) {
        CrewEntity crew = crewRepository.getById(id);

        if(request.getInstagram() != null) {
            crew.setInstagram(request.getInstagram());
        }
        if(request.getLogo_url() != null) {
            crew.setLogo_url(request.getLogo_url());
        }
        if(request.getName() != null) {
            crew.setName(request.getName());
        }

        crewRepository.save(crew);

        return request;
    }

    //Todo -> Alterar para CrewDto
    public List<CrewEntity> getAllCrews() {
        return crewRepository.findAll();
    }

    //Todo -> Alterar para CrewDto
    public CrewDto findCrewById(Long id) {
        return mapperToDto.toDto(crewRepository.getById(id));
    }

}
