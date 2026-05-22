package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentByID(@PathVariable Long id){
        studentService.deleteStudentByID(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/department/{department}")
    public List<Student> getStudentByDepartment(@PathVariable String department){
        return studentService.getStudentByDepartment(department);
    }

    @GetMapping("/higherscore/{marks}")
    public List<Student> getHigherScore(@PathVariable Double marks){
        return studentService.getHigherScore(marks);
    }

    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name){
        return studentService.searchByName(name);
    }
}
