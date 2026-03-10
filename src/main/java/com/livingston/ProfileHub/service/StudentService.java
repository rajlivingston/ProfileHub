package com.livingston.ProfileHub.service;

import com.livingston.ProfileHub.entity.Student;
import com.livingston.ProfileHub.exception.ResourceNotFoundException;
import com.livingston.ProfileHub.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public Student updateStudent(Long id, Student student) {

        Student existing = getStudentById(id);

        existing.setName(student.getName());
        existing.setDegree(student.getDegree());
        existing.setDestination(student.getDestination());
        existing.setResumePath(student.getResumePath());
        existing.setVisumePath(student.getVisumePath());

        return repository.save(existing);
    }

    public Student updateResumePath(Long id, String path) {
        Student student = getStudentById(id);
        student.setResumePath(path);
        return repository.save(student);
    }

    public Student updateVisumePath(Long id, String path) {
        Student student = getStudentById(id);
        student.setVisumePath(path);
        return repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    public Page<Student> getStudentsPaginated(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);
    }
}