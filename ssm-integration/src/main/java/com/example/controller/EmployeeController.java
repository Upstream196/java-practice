package com.example.controller;

import com.example.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public List<Employee> find() {
        List<Employee> all = employeeService.findAll();
        return all;
    }
}
