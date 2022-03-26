package br.frlabs.classy.service;

import br.frlabs.classy.dto.EsportDto;
import br.frlabs.classy.enums.PlataformEnum;
import br.frlabs.classy.model.EsportEntity;
import br.frlabs.classy.repository.EsportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EsportService {

    private final EsportRepository esportRepository;

    public List<EsportEntity> getAllEsport() {
        return esportRepository.findAll();
    }

    public EsportDto createEsport(EsportDto request) {
        EsportEntity esport = new EsportEntity();
        esport.setGameName(request.getGameName());
        esport.setPlataform(PlataformEnum.getEnum( request.getPlataform() ));
        esportRepository.save(esport);
        return request;
    }
}
