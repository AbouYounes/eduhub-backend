package de.karim.eduhub.controller;

import de.karim.eduhub.model.Course;
import de.karim.eduhub.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to handle all HTTP request related to courses.
 * Accessible under /api/v1/courses
 */
@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    /**
     * GET request to fetch all courses.
     * URL: http://localhost:8080/api/v1/courses
     */
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    /**
     * POST request to create a new course.
     * URL: http://localhost:8080/api/v1/courses
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //Returns HTTP 201 instead of 200
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }
}
