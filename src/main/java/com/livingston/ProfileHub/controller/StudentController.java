package com.livingston.ProfileHub.controller;

import com.livingston.ProfileHub.entity.Student;
import com.livingston.ProfileHub.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }

    @GetMapping("/page")
    public Page<Student> getStudentsPage(
            @RequestParam int page,
            @RequestParam int size) {

        return service.getStudentsPaginated(page, size);
    }

    @PostMapping("/{id}/upload-resume")
    public String uploadResume(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException {
        String fileName = "resume_" + id + "_" + file.getOriginalFilename();
        Path path = Paths.get("uploads/resumes/" + fileName);
        Files.createDirectories(path.getParent());
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        service.updateResumePath(id, path.toString());
        return "Resume uploaded successfully for student " + id;
    }

    @PostMapping("/{id}/upload-visume")
    public String uploadVisume(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException {
        String fileName = "visume_" + id + "_" + file.getOriginalFilename();
        Path path = Paths.get("uploads/visumes/" + fileName);
        Files.createDirectories(path.getParent());
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        service.updateVisumePath(id, path.toString());
        return "Visume uploaded successfully for student " + id;
    }
}