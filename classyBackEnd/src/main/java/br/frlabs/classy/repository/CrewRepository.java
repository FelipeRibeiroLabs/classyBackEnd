package br.frlabs.classy.repository;

import br.frlabs.classy.model.CrewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<CrewEntity, Long> {
    CrewEntity findByName(String crewName);
}
