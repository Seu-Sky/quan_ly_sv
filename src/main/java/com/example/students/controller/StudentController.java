package com.example.students.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.students.entity.Student;
import com.example.students.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping({"", "/"})
    public String listStudents(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Student> students = studentService.searchStudents(keyword);
        model.addAttribute("students", students);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("formTitle", "Thêm sinh viên");
        return "form";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("formTitle", student.getId() == null ? "Thêm sinh viên" : "Sửa thông tin sinh viên");
            return "form";
        }
        if (student.getId() == null) {
            studentService.addStudent(student);
        } else {
            studentService.updateStudent(student.getId(), student);
        }
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        model.addAttribute("formTitle", "Sửa thông tin sinh viên");
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}