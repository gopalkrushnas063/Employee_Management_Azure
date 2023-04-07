package com.example.employee_management_azure.controller;

import com.example.employee_management_azure.entity.Employee;
import com.example.employee_management_azure.exception.EmployeeException;
import com.example.employee_management_azure.services.EmployeeServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;


    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployeeHandler(@Valid @RequestBody Employee employee) throws EmployeeException{
        Employee employee1 = employeeServices.registerNewEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }
}
