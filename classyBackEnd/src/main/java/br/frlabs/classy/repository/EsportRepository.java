package br.frlabs.classy.repository;

import br.frlabs.classy.model.EsportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsportRepository extends JpaRepository<EsportEntity, Long> {
}
