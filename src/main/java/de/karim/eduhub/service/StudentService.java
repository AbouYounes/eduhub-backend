package de.karim.eduhub.service;

import de.karim.eduhub.dto.StudentDTO;
import de.karim.eduhub.exception.AlreadyExistsException;
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

    public StudentDTO registerStudent(Student student) {
        //Business Logic: Check if email is already taken
        if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
            throw new AlreadyExistsException("A student with email " + student.getEmail() + " already exist.");
        }
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
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
