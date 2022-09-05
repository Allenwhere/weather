package com.example.employee.service;

import com.example.employee.domain.entity.Employee;
import com.example.employee.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Value("${employee-endpoint}")
    private String url;

    private final RestTemplate restTemplate;
    @Autowired
    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAll(){

        return restTemplate.getForObject(url, EmployeeDTO.class).getData();
    }
    public List<Employee> getAgeLargerThan(int age){
        return restTemplate.getForObject(url, EmployeeDTO.class).getData()
                .stream()
                .filter(e -> e.getAge() >= age)
                .collect(Collectors.toList());
    }
}
