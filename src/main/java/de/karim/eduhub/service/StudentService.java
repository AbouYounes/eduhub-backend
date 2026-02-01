package de.karim.eduhub.service;

import de.karim.eduhub.dto.StudentDTO;
import de.karim.eduhub.model.Course;
import de.karim.eduhub.model.Student;
import de.karim.eduhub.repository.CourseRepository;
import de.karim.eduhub.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public List<StudentDTO> getAllStudent() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private StudentDTO convertToDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .email(student.getEmail())
                .enrolledCourseTitles(student.getEnrolledCourses().stream()
                        .map(Course::getTitle)
                        .collect(Collectors.toList()))
                .build();
    }

    public Student registerStudent(Student student) {
        //Business Logic: Check if email is already taken
        if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists!");
            //Later i will handle this with a professional Exception Handler
        }
        return studentRepository.save(student);
    }

    public void enrollStudentInCourse(long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getEnrolledCourses().add(course);
        studentRepository.save(student);
    }

}
