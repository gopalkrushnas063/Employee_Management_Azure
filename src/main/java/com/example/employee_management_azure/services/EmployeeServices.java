package com.example.employee_management_azure.services;

import com.example.employee_management_azure.entity.Employee;
import com.example.employee_management_azure.exception.EmployeeException;

public interface EmployeeServices {
    public Employee registerNewEmployee(Employee employee) throws EmployeeException;
}
