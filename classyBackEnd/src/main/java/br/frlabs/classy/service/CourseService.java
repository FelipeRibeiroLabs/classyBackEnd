package br.frlabs.classy.service;

import br.frlabs.classy.dto.CourseDto;
import br.frlabs.classy.mapper.course.CourseToDtoMapper;
import br.frlabs.classy.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseToDtoMapper mapperToDto;

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream().map(mapperToDto::toDto).collect(Collectors.toList());
    }

//    public CourseDto createCourse(CourseDto request) {
//        CourseEntity course = new CourseEntity();
//        course.setUniversity(universityRepository.getById(request.getUniversityId()));
//        course.setCourseName(request.getCourseName());
//
//        courseRepository.save(course);
//        return request;
//    }

}