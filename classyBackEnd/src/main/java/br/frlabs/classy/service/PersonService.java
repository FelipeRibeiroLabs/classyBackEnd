package br.frlabs.classy.service;

import br.frlabs.classy.dto.PersonDto;
import br.frlabs.classy.exception.ApiRequestException;
import br.frlabs.classy.model.PersonEntity;
import br.frlabs.classy.repository.PersonRepository;
import br.frlabs.classy.utils.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final EmailValidator emailValidator;

    public List<PersonEntity> listAllPersonFromCrew(Long crewId) {
        List<PersonEntity> listByCrew = personRepository.findByCrewId(crewId);
        return listByCrew;
    }

    public PersonDto createPerson(PersonDto request) {
        PersonEntity person = new PersonEntity();

        //todo -> Verify that email and nickname is not taken
        if(personRepository.findByNickname(request.getNickname()).isPresent()){
            throw new ApiRequestException("Ops, nickname ocupado, por favor escolha outro!");
        }
        if(personRepository.findByEmail(request.getEmail()).isPresent()){
            throw new ApiRequestException("Ops, email já cadastrado, por favor escolha outro!");
        }
        if(!emailValidator.test(request.getEmail())){
            throw new ApiRequestException("E-mail inserido inválido!");
        }
        //todo -> Validate Email

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
