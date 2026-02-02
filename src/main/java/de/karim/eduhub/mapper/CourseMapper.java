package de.karim.eduhub.mapper;

import de.karim.eduhub.dto.CourseDTO;
import de.karim.eduhub.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDTO toDTO(Course course);

    Course toEntity(CourseDTO courseDTO);
}
