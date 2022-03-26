package br.frlabs.classy.controller;

import br.frlabs.classy.dto.EsportDto;
import br.frlabs.classy.model.EsportEntity;
import br.frlabs.classy.service.EsportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/esport")
public class EsportController {

    private final EsportService esportService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<EsportEntity> getAllEsport() {
        return  esportService.getAllEsport();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public EsportDto createEsport (@RequestBody EsportDto request) {
        return esportService.createEsport(request);
    }
}
