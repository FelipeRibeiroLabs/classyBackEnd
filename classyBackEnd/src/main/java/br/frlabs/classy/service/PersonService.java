package br.frlabs.classy.service;

import br.frlabs.classy.dto.PersonDto;
import br.frlabs.classy.model.PersonEntity;
import br.frlabs.classy.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<PersonEntity> listAllPersonFromCrew(Long crewId) {
        List<PersonEntity> listByCrew = personRepository.findByCrewId(crewId);
        return listByCrew;
    }

    public PersonDto createPerson(PersonDto request) {
        PersonEntity person = new PersonEntity();
        person.setName(request.getName());
        person.setEmail(request.getEmail());
        person.setNickname(request.getNickname());
        person.setPhoneNumber(request.getPhoneNumber());
        person.setNumber(request.getNumber());
        personRepository.save(person);
        return request;
    }



    public PersonEntity findPersonByNickname(String nickname) {
        return personRepository.findByNickname(nickname).get();
    }

    public void removePerson(Long id) {
        personRepository.delete(personRepository.getById(id));
    }

}
