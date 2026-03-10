package com.livingston.ProfileHub.repository;
import com.livingston.ProfileHub.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
