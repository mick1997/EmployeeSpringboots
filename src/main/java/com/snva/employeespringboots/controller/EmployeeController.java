package com.snva.employeespringboots.controller;

import com.snva.employeespringboots.model.Employee;
import com.snva.employeespringboots.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 36000, origins = "*" , allowedHeaders = "*")
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @PostMapping("/addemployee")
    public ResponseEntity createEmployee(@Valid @RequestBody Employee employee) {
        try {
            return ResponseEntity.ok(employeeService.save(employee));
        }
        catch (Exception e) {
            return ResponseEntity.ok("Duplicate Entity exist: " + e.getMessage());
        }
    }
}
