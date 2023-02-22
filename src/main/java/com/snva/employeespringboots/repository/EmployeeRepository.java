package com.snva.employeespringboots.repository;

import com.snva.employeespringboots.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

    Employee findEmployeeByEmail(String email);
}
