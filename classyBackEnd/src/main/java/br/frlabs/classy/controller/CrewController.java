package br.frlabs.classy.controller;

import br.frlabs.classy.dto.CrewDto;
import br.frlabs.classy.model.CrewEntity;
import br.frlabs.classy.service.CrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
//        throw new ApiRequestException("Ops, ocorreu um erro em nosso servidor!");
        return crewService.getAllCrews();
    }

    @GetMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CrewDto getCrewById(@PathVariable("id") Long id) {
        return crewService.findCrewById(id);
    }


    @PostMapping(path = "{personId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CrewDto createCrew(@PathVariable("personId") Long personId, @RequestBody @Valid CrewDto request) {
        return crewService.createCrew(personId, request);
    }

    @PutMapping(path = "/{crewId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCrew(@RequestBody CrewDto request, @PathVariable("crewId") Long crewId) {
        crewService.updateCrew(request, crewId);
    }

    @PostMapping(path = "{crewId}")
    public void addPersonInCrew(
            @PathVariable("crewId") Long crewId,
            @RequestParam Long person,
            @RequestParam String nickname
    ) {
        crewService.addPersonInCrew(person ,crewId, nickname);
    }

}
