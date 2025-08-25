package com.example;


//规定数据库方法
public interface EmployeeMapper {
    com.example.Employee queryById(Integer id);

    int deleteById(Integer id);
}
