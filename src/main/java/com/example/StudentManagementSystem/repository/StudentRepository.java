package com.example.StudentManagementSystem.repository;

import com.example.StudentManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student,Long> {

    List<Student> findByDepartment(String department);

    @Query("Select s from Student s where s.marks> :marks")
    List<Student> findStudentwithMarksGreaterThan(@Param("marks") Double marks);

    @Query("Select s from Student s where s.name like %:keyword")

    /* @Query(```
         SELECT s FROM Student s
         WHERE LOWER(s.name) LIKE LOWER(CONCAT(%, :keyword, %))
         ```)
     */

    List<Student> searchByName(@Param("keyword") String keyword);

}

