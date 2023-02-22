package com.snva.employeespringboots.service;

import com.snva.employeespringboots.model.Employee;

public interface EmployeeService {

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
     * Create a new Employee
     * @param SeqName
     * @return
     */
    long createEmployee(String SeqName);
}
