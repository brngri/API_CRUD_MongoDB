package com.mongodb.crud.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.crud.dto.EmployeeDTO;
import com.mongodb.crud.entity.Employee;
import com.mongodb.crud.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(EmployeeDTO employeeDTO) {
        try {

            Employee emp = Employee.builder()
                    .name(employeeDTO.getName())
                    .salary(employeeDTO.getSalary())
                    .location(employeeDTO.getLocation())
                    .build();

            employeeRepository.save(emp);

            return "Employee Created Successfully";
        } catch (Exception e) {

            return "Error with Creating the employee";
        }

    }

    public List<Employee> listaAllEmployees() {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            System.err.println("Error with searching all employees");
            return Collections.emptyList();
        }

    }

    public String deleteEmployee(String id) {
        try {
            if (employeeRepository.existsById(id)) {
                employeeRepository.deleteById(id);
                return "Employee deleted successfully";
            } else {
                return "Employee does not exist";
            }

        } catch (Exception e) {
            System.err.println("Error with deleting de employee");
            return e.getMessage();
        }
    }

    public String updateEmployee(EmployeeDTO employeeDTO) {
        try {
            if (employeeRepository.existsById(employeeDTO.getId())) {
                Employee emp = Employee.builder()
                        .id(employeeDTO.getId())
                        .name(employeeDTO.getName())
                        .salary(employeeDTO.getSalary())
                        .location(employeeDTO.getLocation())
                        .build();

                employeeRepository.save(emp);
                return "Employee Updated Successfully";
            } else {
                return "Employee does not exist";
            }

        } catch (Exception e) {
            return "Error with Updating the employee";
        }

    }

}
