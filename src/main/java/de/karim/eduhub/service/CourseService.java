package de.karim.eduhub.service;

import de.karim.eduhub.dto.CourseDTO;
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

    /**
     * Retrieves all courses from the database.
     * */
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CourseDTO convertToDTO(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .durationHours(course.getDurationHours())
                .build();
    }

    /**
     * Saves a new course to the databasse.
     */
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
}
