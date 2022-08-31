package com.example.employee.dto;

import com.example.employee.domain.entity.Employee;

import java.util.List;

public class EmployeeDTO {
    private String status;
    private List<Employee> data;

    public String getStatus(){
        return status;
    }
    public List<Employee> getData() {
        return data;
    }
}
