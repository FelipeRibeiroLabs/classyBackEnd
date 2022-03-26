package br.frlabs.classy.service;

import br.frlabs.classy.dto.UniversityDto;
import br.frlabs.classy.model.UniversityEntity;
import br.frlabs.classy.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;

    public List<UniversityEntity> getAllUniversities() {
        return universityRepository.findAll();
    }

    public UniversityDto createUniversity(UniversityDto request) {
        UniversityEntity university = new UniversityEntity();
        university.setUniversityName(request.getUniversityName());
        university.setCity(request.getCity());
        university.setState(request.getState());
        universityRepository.save(university);
        return request;
    }
}
