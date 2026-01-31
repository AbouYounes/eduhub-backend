package de.karim.eduhub.repository;

import de.karim.eduhub.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing Course data from the database.
 * JpaRepository provides standard methods like save(), findById(), and delete().
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
