package br.frlabs.classy.controller;

import br.frlabs.classy.dto.PersonDto;
import br.frlabs.classy.model.PersonEntity;
import br.frlabs.classy.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;


    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<PersonEntity> getAllPersonFromCrew(@PathVariable(value = "id") Long id) {
        return personService.listAllPersonFromCrew(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto createPerson(@RequestBody PersonDto request) {
        return personService.createPerson(request);
    }


//    @PutMapping(path = "/{personId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updatePerson(@RequestBody PersonDto request, @PathVariable("personId") Long personId) {
//        personService.updateCrew(request, personId);
//    }


    @GetMapping(value = "{nickname}")
    @ResponseStatus(HttpStatus.OK)
    public PersonEntity getPersonByNickname(@PathVariable(value = "nickname") String nickname) {
        return personService.findPersonByNickname(nickname);
    }

    //todo -> RemovePerson

}
