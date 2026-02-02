package de.karim.eduhub.service;

import de.karim.eduhub.dto.CourseDTO;
import de.karim.eduhub.mapper.CourseMapper;
import de.karim.eduhub.model.Course;
import de.karim.eduhub.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for handling business logic related to Courses.
 */
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    /**
     * Retrieves all courses from the database.
     * */
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Saves a new course to the databasse.
     */
    public CourseDTO createCourse(Course course) {
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDTO(savedCourse);
    }
}
