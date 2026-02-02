package de.karim.eduhub.service;

import de.karim.eduhub.dto.CourseDTO;
import de.karim.eduhub.mapper.CourseMapper;
import de.karim.eduhub.model.Course;
import de.karim.eduhub.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private CourseMapper courseMapper;

    @InjectMocks
    private CourseService courseService;

    @Test
    void getAllCourses_ShouldReturnListOfDTOs() {
        //GIVEN
        Course course = Course
                .builder()
                .id(1L)
                .title("Java Masterclass")
                .build();
        CourseDTO dto = CourseDTO
                .builder()
                .id(1L)
                .title("Java Masterclass")
                .build();

        when(courseRepository.findAll()).thenReturn(List.of(course));
        when(courseMapper.toDTO(course)).thenReturn(dto);

        //WHEN
        List<CourseDTO> result = courseService.getAllCourses();

        //THEN
        assertEquals(1, result.size());
        assertEquals("Java Masterclass", result.get(0).getTitle());
        verify(courseRepository, times(1)).findAll();
    }
}
