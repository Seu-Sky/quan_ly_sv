package com.example.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.students.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByMssv(String mssv);

    @Query("SELECT s FROM Student s WHERE " +
           "LOWER(s.hoTen) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(s.mssv) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(s.lop) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Student> search(@Param("keyword") String keyword);
}