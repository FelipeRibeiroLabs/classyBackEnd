package br.frlabs.classy.controller;

import br.frlabs.classy.dto.UniversityDto;
import br.frlabs.classy.model.UniversityEntity;
import br.frlabs.classy.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/university")
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UniversityEntity> getAllUniversity() {
        return  universityService.getAllUniversities();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public UniversityDto createUniversity (@RequestBody UniversityDto request) {
        return universityService.createUniversity(request);
    }
}
