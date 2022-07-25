package com.encora.PatitoSoft.controllers;

import com.encora.PatitoSoft.entities.Employee;
import com.encora.PatitoSoft.repositories.projections.EmployeeSimpleSearch;
import com.encora.PatitoSoft.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<EmployeeSimpleSearch> getEmployeeSearchInfo(@RequestParam(defaultValue = "") String firstName,
                                                            @RequestParam(defaultValue = "") String lastName,
                                                            @RequestParam(defaultValue = "") String position){
        return employeeService.getEmployeeSearchInfo(firstName, lastName, position);
    }

    @GetMapping("/employees/{corporateEmail}")
    public EmployeeSimpleSearch getEmployeeByEmail(@PathVariable String corporateEmail){
        return employeeService.getEmployeeByEmail(corporateEmail);
    }

}
