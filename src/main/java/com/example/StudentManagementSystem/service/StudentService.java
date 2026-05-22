package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.exception.ResourceNotFoundException;
import com.example.StudentManagementSystem.repository.StudentRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void deleteStudentByID(Long id){
        Student student =studentRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Student id does not exists:" +id));
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentByDepartment(String department){
        return studentRepository.findByDepartment(department);
    }

    public List<Student> getHigherScore(Double marks){
        return studentRepository.findStudentwithMarksGreaterThan(marks);
    }

    public List<Student> searchByName(String name){
        return studentRepository.searchByName(name);
    }
}

