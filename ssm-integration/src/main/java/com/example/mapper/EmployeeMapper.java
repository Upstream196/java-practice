package com.example.mapper;

import com.example.Employee;
import com.example.service.EmployeeService;

import java.util.List;


public interface EmployeeMapper  {
   List<Employee> queryList();
}
