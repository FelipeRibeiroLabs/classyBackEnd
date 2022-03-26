package br.frlabs.classy.service;

import br.frlabs.classy.dto.SchoolDto;
import br.frlabs.classy.model.SchoolEntity;
import br.frlabs.classy.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public List<SchoolEntity> getAllSchool() {
        return schoolRepository.findAll();
    }

    public SchoolDto createSchool(SchoolDto request) {
        SchoolEntity school = new SchoolEntity();
        school.setSchoolName(request.getSchoolName());
        school.setCity(request.getCity());
        school.setState(request.getState());
        schoolRepository.save(school);
        return request;
    }
}
