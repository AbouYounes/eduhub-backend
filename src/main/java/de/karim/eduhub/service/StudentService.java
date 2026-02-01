package de.karim.eduhub.service;

import de.karim.eduhub.model.Course;
import de.karim.eduhub.model.Student;
import de.karim.eduhub.repository.CourseRepository;
import de.karim.eduhub.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
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
