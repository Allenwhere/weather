package com.example.search.controller;

import com.example.search.service.EmployeeService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final EmployeeService employeeService;

    @Autowired
    public SearchController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/weather/search/employees")
    public ResponseEntity<?> getDetails(@RequestParam List<Integer> ages) {
        //TODO
        return new ResponseEntity<>(employeeService.fetchEmployeeByAges(ages), HttpStatus.OK);
    }
}
