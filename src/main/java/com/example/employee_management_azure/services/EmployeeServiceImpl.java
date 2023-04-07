package com.example.employee_management_azure.services;

import com.example.employee_management_azure.entity.Employee;
import com.example.employee_management_azure.exception.EmployeeException;
import com.example.employee_management_azure.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeServices{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee registerNewEmployee(Employee employee) throws EmployeeException {
        return employeeRepository.save(employee);
    }
}
