package com.snva.employeespringboots.service;

import com.snva.employeespringboots.model.Employee;
import com.snva.employeespringboots.repository.EmployeeRepository;
import com.snva.employeespringboots.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    public EmployeeServiceImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public Employee signup(Employee employee) {
        return null;
    }

    @Override
    public String findEmployeeByEmail(String email) {
        Optional<Employee> employee = Optional.ofNullable(employeeRepository.findEmployeeByEmail(email));
        if (employee.isPresent()) {
            return "This employee exists" + employee;
        }
        return "Employee not found!" + employee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) throws Exception {
        Employee emp = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if (emp != null) {
            throw new Exception("Employee email is already exist: " + employee.getEmail());
        }
        return employeeRepository.save(employee);
    }
}
