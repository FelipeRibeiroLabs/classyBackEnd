package br.frlabs.classy.controller;

import br.frlabs.classy.dto.CourseDto;
import br.frlabs.classy.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/curso")
public class CourseController {

    private final CourseService courseService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }
    //todo -> Change to ManyToMany

}
