package com.example.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.students.entity.Student;
import com.example.students.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return null;
        }
        student.setMssv(studentDetails.getMssv());
        student.setHoTen(studentDetails.getHoTen());
        student.setNgaySinh(studentDetails.getNgaySinh());
        student.setLop(studentDetails.getLop());
        student.setEmail(studentDetails.getEmail());
        student.setSdt(studentDetails.getSdt());
        return studentRepository.save(student);
    }

    public boolean deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }

    public List<Student> searchStudents(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllStudents();
        }
        return studentRepository.search(keyword.trim());
    }
}