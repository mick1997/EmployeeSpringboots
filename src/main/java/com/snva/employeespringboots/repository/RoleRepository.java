package com.snva.employeespringboots.repository;

import com.snva.employeespringboots.model.Employee;
import com.snva.employeespringboots.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String email);
}
