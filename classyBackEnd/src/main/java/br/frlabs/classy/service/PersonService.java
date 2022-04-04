package br.frlabs.classy.service;

import br.frlabs.classy.dto.PersonDto;
import br.frlabs.classy.exception.ApiRequestException;
import br.frlabs.classy.model.CrewEntity;
import br.frlabs.classy.model.PersonEntity;
import br.frlabs.classy.repository.CrewRepository;
import br.frlabs.classy.repository.PersonRepository;
import br.frlabs.classy.utils.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final CrewRepository crewRepository;
    private final EmailValidator emailValidator;

//    public List<PersonEntity> listAllPersonFromCrew(Long crewId) {
//        List<PersonEntity> listByCrew = personRepository.findByCrewId(crewId);
//        return listByCrew;
//    }

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

    public void addPersonToAdmInCrew(Long adminId ,Long crewId, String nickname) {
        PersonEntity admin = personRepository.getById(adminId);
        CrewEntity crew = crewRepository.getById(crewId);
        PersonEntity personToAdd = personRepository
                .findByNickname(nickname)
                .orElseThrow(() -> new ApiRequestException("Nickname não encontrado!"));

        if(personToAdd.getCrews().stream().noneMatch(e -> Objects.equals(e, crew))){
            throw new ApiRequestException("Essa pessoa não está presente na sua turma!");
        }

        if(admin.getAdmCrew().stream().anyMatch(e -> Objects.equals(e.getId(), crewId))) {
            personToAdd.getAdmCrew().add(crew);
            personRepository.save(personToAdd);
        } else {
            throw new ApiRequestException("Você não possui permissão!");
        }
    }

}
