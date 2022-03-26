package br.frlabs.classy.service;

import br.frlabs.classy.dto.UniformDto;
import br.frlabs.classy.enums.UniformTypeEnum;
import br.frlabs.classy.model.CrewEntity;
import br.frlabs.classy.model.PersonEntity;
import br.frlabs.classy.model.UniformEntity;
import br.frlabs.classy.repository.CrewRepository;
import br.frlabs.classy.repository.PersonRepository;
import br.frlabs.classy.repository.UniformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniformService {

    private final UniformRepository uniformRepository;
    private final CrewRepository crewRepository;
    private final PersonRepository personRepository;

    //todo -> Transform to UniformDto
    public List<UniformEntity> getUniformByCrew(Long id) {
        return uniformRepository.findByCrewId(id);
    }

    public List<UniformEntity> getUniformByPerson(Long id) {
        return uniformRepository.findByPersonId(id);
    }

    public List<UniformEntity> getAllUniforms() {
        return uniformRepository.findAll();
    }

    public UniformDto createUniform(UniformDto request) {
        UniformEntity uniform = new UniformEntity();

        uniform.setType(UniformTypeEnum.getEnum(request.getType()));
        uniform.setUniform_url(request.getUniform_url());

        CrewEntity crew = crewRepository.getById(request.getCrewId());
        uniform.setCrew(crew);

        PersonEntity person = personRepository.getById(request.getPersonId());
        uniform.setPerson(person);

        uniformRepository.save(uniform);
        return request;
    }
}
