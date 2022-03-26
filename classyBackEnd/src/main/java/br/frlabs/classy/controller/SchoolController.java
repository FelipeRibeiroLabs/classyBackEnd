package br.frlabs.classy.controller;

import br.frlabs.classy.dto.SchoolDto;
import br.frlabs.classy.model.SchoolEntity;
import br.frlabs.classy.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<SchoolEntity> getAllSchool() {
        return  schoolService.getAllSchool();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public SchoolDto createSchool (@RequestBody SchoolDto request) {
        return schoolService.createSchool(request);
    }
}
