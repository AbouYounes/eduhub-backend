package de.karim.eduhub.service;

import de.karim.eduhub.model.Course;
import de.karim.eduhub.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    /**
     * Saves a new course to the databasse.
     */
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
}
