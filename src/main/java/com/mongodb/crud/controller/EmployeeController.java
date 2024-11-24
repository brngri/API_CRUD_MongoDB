package com.mongodb.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.crud.dto.EmployeeDTO;
import com.mongodb.crud.entity.Employee;
import com.mongodb.crud.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping("/listAll")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Employee> listaAllEmployee(){
        return employeeService.listaAllEmployees();
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteEmployee(@RequestParam String id){
        return employeeService.deleteEmployee(id); 
    }

    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(employeeDTO); 
    }


}
