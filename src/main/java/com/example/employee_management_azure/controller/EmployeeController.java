package com.example.employee_management_azure.controller;

import com.example.employee_management_azure.entity.Employee;
import com.example.employee_management_azure.exception.EmployeeException;
import com.example.employee_management_azure.services.EmployeeServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/")
    public String viewHomePage() throws EmployeeException {

        return "index";
    }

    @GetMapping("/employee_list")
    public String viewEmployeeList(Model model) throws EmployeeException {
        model.addAttribute("listEmployees",employeeServices.allEmployeeList());
        return "employee_list";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "register_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) throws EmployeeException {
        employeeServices.saveEmployee(employee);
        return "redirect:/employee_list";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id,Model model) throws EmployeeException {
        Employee employee = employeeServices.getEmployeeByID(id);
        model.addAttribute("employee",employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) throws EmployeeException{
        this.employeeServices.deleteEmployeeByID(id);
        return "redirect:/employee_list";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Employee> page = employeeServices.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployees", listEmployees);
        return "index";
    }

}
