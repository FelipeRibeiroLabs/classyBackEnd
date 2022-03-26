package br.frlabs.classy.repository;

import br.frlabs.classy.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findByCrewId(Long crewId);

    Optional<PersonEntity> findByNickname(String nickname);
}
