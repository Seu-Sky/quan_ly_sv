package com.example.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.students.entity.Student;
import com.example.students.service.StudentService;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    @Autowired
    private StudentService studentService;

 
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }


    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Xóa thành công sinh viên ID: " + id;
    }

   
    @GetMapping("/search")
    public List<Student> searchStudent(@RequestParam String keyword) {
        return studentService.searchStudents(keyword);
    }


    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

  
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

 
    @PostMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }
}