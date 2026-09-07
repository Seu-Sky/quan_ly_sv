package com.example.students.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Mã số sinh viên không được để trống")
    @Column(name = "mssv", unique = true, nullable = false, length = 20)
    private String mssv;

    @NotBlank(message = "Họ tên không được để trống")
    @Column(name = "ho_ten", nullable = false, length = 100)
    private String hoTen;

    @Column(name = "ngay_sinh", length = 20)
    private String ngaySinh;

    @Column(name = "lop", length = 50)
    private String lop;

    @Email(message = "Email không đúng định dạng")
    @Column(name = "email", length = 100)
    private String email;

    @Pattern(regexp = "^$|^[0-9]{9,11}$", message = "số điện thoại không hợp lệ")
    @Column(name = "sdt", length = 15)
    private String sdt;

    public Student() {
    }

    public Student(String mssv, String hoTen, String ngaySinh, String lop, String email, String sdt) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.email = email;
        this.sdt = sdt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}