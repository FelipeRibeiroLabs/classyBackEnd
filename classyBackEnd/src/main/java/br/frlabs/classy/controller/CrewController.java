package br.frlabs.classy.controller;

import br.frlabs.classy.dto.CrewDto;
import br.frlabs.classy.model.CrewEntity;
import br.frlabs.classy.service.CrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/turma")
public class CrewController {

    private final CrewService crewService;

    @CrossOrigin(origins = "*")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CrewEntity> getAllCrews() {
        return crewService.getAllCrews();
    }

    @GetMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CrewDto getCrewById(@PathVariable("id") Long id) {
        return crewService.findCrewById(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CrewDto createCrew(@RequestBody CrewDto request) {
        return crewService.createCrew(request);
    }

    @PutMapping(path = "/{crewId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCrew(@RequestBody CrewDto request, @PathVariable("crewId") Long crewId) {
        crewService.updateCrew(request, crewId);
    }

}
