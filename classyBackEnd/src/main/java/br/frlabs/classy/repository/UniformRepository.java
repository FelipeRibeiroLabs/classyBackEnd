package br.frlabs.classy.repository;

import br.frlabs.classy.model.UniformEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniformRepository extends JpaRepository<UniformEntity, Long> {
    List<UniformEntity> findByPersonId(Long id);
    List<UniformEntity> findByCrewId(Long id);
}
