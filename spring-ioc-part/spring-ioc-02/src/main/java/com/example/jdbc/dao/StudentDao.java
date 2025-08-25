package com.example.jdbc.dao;



import com.example.jdbc.Student;

import java.util.List;

public interface StudentDao {

    List<Student> queryAll();
}
