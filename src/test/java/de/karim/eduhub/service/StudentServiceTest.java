package de.karim.eduhub.service;

import de.karim.eduhub.dto.StudentDTO;
import de.karim.eduhub.exception.AlreadyExistsException;
import de.karim.eduhub.mapper.StudentMapper;
import de.karim.eduhub.model.Student;
import de.karim.eduhub.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository; // Fake Repository

    @Mock
    private StudentMapper studentMapper; // Fake Mapper

    @InjectMocks
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .id(1L)
                .firstname("Karim")
                .lastname("KHATTOU")
                .email("karim@example.com")
                .enrolledCourses(new ArrayList<>())
                .build();
    }

    @Test
    void registerStudent_ShouldSaveStudent_WhenEmailDoesNotExist() {
        // GIVEN
        when(studentRepository.findByEmail(student.getEmail())).thenReturn(Optional.empty());
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(studentMapper.toDTO(any(Student.class))).thenReturn(new StudentDTO());

        // WHEN
        StudentDTO savedStudent = studentService.registerStudent(student);

        // THEN
        assertNotNull(savedStudent);
        verify(studentRepository, times(1)).save(any(Student.class));
    }

    @Test
    void registerStudent_ShouldThrowException_WhenEmailAlreadyExists() {
        // GIVEN
        when(studentRepository.findByEmail(student.getEmail())).thenReturn(Optional.of(student));

        // WHEN & THEN
        assertThrows(AlreadyExistsException.class, () -> {
            studentService.registerStudent(student);
        });

        // Ensure that save() has NEVER been called
        verify(studentRepository, never()).save(any(Student.class));
    }
}