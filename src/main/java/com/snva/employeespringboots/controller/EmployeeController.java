package com.snva.employeespringboots.controller;

import com.snva.employeespringboots.model.Employee;
import com.snva.employeespringboots.repository.EmployeeRepository;
import com.snva.employeespringboots.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 36000, origins = "*" , allowedHeaders = "*")
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository  employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/addemployee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        employee.setId(employeeService.createEmployee(Employee.SEQUENCE_NAME));
        return employeeRepository.save(employee);
    }
}
