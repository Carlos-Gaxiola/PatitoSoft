package com.encora.PatitoSoft.controllers;

import com.encora.PatitoSoft.DTO.EmployeeInfo;
import com.encora.PatitoSoft.entities.Employee;
import com.encora.PatitoSoft.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findTodos();
    }

    @PostMapping("/employees")
    public EmployeeInfo addEmployee(@RequestBody EmployeeInfo employeeInfo){
        employeeService.save(employeeInfo);
        return employeeInfo;
    }

}
