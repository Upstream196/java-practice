package com.example.jdbc.Service;

import com.example.jdbc.Student;
import com.example.jdbc.dao.StudentDao;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("studentService:"+studentList);
        return studentList;
    }
}
