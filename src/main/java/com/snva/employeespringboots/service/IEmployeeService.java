package com.snva.employeespringboots.service;

import com.snva.employeespringboots.model.Employee;

import java.util.List;

public interface IEmployeeService {

    /***
     * Register a new Employee
     * @param employee
     * @return
     */
    Employee signup(Employee employee);

    /**
     * Search an existing Employee
     * @param email
     * @return
     */
    String findEmployeeByEmail(String email);

    /**
     * Find all Employee
     * @return
     */
    List<Employee> findAll();

    /**
     * Save the employee
     * @param employee
     * @return
     * @throws Exception
     */
    Employee save(Employee employee) throws Exception;
}
