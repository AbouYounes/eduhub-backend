package de.karim.eduhub.repository;

import de.karim.eduhub.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //Custom method to find a student by email (useful for login)
    Optional<Student> findByEmail(String email);
}
