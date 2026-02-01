package de.karim.eduhub.controller;

import de.karim.eduhub.dto.StudentDTO;
import de.karim.eduhub.model.Student;
import de.karim.eduhub.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDTO> getAll() {
        return studentService.getAllStudent();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student register(@Valid @RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @PutMapping("/{studentId}/courses/{courseId}")
    public void enrollStudentToCourse(
            @PathVariable long studentId,
            @PathVariable long courseId) {
                studentService.enrollStudentInCourse(studentId, courseId);
    }
}
