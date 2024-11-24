package com.mongodb.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.crud.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    
}
