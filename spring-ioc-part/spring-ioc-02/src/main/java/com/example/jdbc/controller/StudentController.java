package com.example.jdbc.controller;

import com.example.jdbc.Service.StudentService;
import com.example.jdbc.Student;
import com.example.jdbc.dao.StudentDao;

import java.util.List;

public class StudentController {
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll(){
        List<Student> all= studentService.findAll();
        System.out.println("最终学院数据："+all);
    }

}
