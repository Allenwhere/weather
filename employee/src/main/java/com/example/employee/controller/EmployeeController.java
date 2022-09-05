package com.example.employee.controller;

import com.example.employee.domain.entity.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
//    @GetMapping("/employees")
//    public List<Employee> getAll() {
//       return employeeService.getAll();
//    }
    @GetMapping("/employees")
    public List<Employee> getAgerLargerThan(@RequestParam int age) {
        return employeeService.getAgeLargerThan(age);
    }
}
