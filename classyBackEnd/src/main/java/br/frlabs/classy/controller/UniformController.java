package br.frlabs.classy.controller;

import br.frlabs.classy.dto.UniformDto;
import br.frlabs.classy.model.UniformEntity;
import br.frlabs.classy.service.UniformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/uniform")
public class UniformController {

    private final UniformService uniformService;

    //TODO -> REMOVE THIS FILTER AND FIND THE CREW WITH REPOSITORY
    @GetMapping(value = "{crewId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UniformEntity> getAllUniforms(@PathVariable(value ="crewId") Long crewId) {
        return  uniformService.getUniformByCrew(crewId);
    }

    @GetMapping(value = "/person/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UniformEntity> getAllUniformsByPerson(@PathVariable(value ="personId") Long personId) {
        return uniformService.getUniformByPerson(personId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UniformEntity> getAll() {
        return  uniformService.getAllUniforms();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public UniformDto createUniform (@RequestBody UniformDto request) {
        return uniformService.createUniform(request);
    }
}
