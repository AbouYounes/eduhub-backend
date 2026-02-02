package de.karim.eduhub.mapper;

import de.karim.eduhub.dto.StudentDTO;
import de.karim.eduhub.model.Course;
import de.karim.eduhub.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "enrolledCourseTitles", source = "enrolledCourses", qualifiedByName = "mapCoursesToTitles")
    StudentDTO toDTO(Student student);

    Student toEntity(StudentDTO studentDTO);

    @Named("mapCoursesToTitles")
    default List<String> mapCourseToTitles(List<Course> courses) {
        if (courses == null) return null;
        return courses.stream()
                .map(Course::getTitle)
                .collect(Collectors.toList());
    }
}
