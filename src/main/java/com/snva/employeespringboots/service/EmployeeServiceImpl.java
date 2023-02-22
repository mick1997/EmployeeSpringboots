package com.snva.employeespringboots.service;

import com.snva.employeespringboots.model.DatabaseSequence;
import com.snva.employeespringboots.model.Employee;
import com.snva.employeespringboots.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

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
    public long createEmployee(String seqName) {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
