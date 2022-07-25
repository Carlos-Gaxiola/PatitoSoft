package com.encora.PatitoSoft.controllers;

import com.encora.PatitoSoft.entities.Employee;
import com.encora.PatitoSoft.repositories.projections.*;
import com.encora.PatitoSoft.services.EmployeeService;
import com.encora.PatitoSoft.services.GendersService;
import com.encora.PatitoSoft.services.PositionsService;
import com.encora.PatitoSoft.services.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PositionsService positionsService;

    @Autowired
    GendersService gendersService;

    @Autowired
    StatesService statesService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findTodos();
    }

    @GetMapping("/positions")
    public List<EmployeePositions> employeePositionsReport(){
        return positionsService.findEmployeesPositions();
    }

    @GetMapping("/genders")
    public List<EmployeeGenders> employeeGendersReport(){
        return gendersService.findEmployeesGenders();
    }

    @GetMapping("/salaries/{ranges}")
    public List<EmployeeSalaries> employeeSalariesReport(@PathVariable int ranges){
        return positionsService.employeeSalariesReport(ranges);
    }

    @GetMapping("/locations/{country}")
    public List<EmployeeLocations> employeeLocationsReport(@PathVariable String country){
        return statesService.employeeLocationsReport(country);
    }

    @GetMapping
    public List<EmployeeSimpleSearch> getEmployeeSearchInfoAdmin(@RequestParam(defaultValue = "") String firstName,
                                                            @RequestParam(defaultValue = "") String lastName,
                                                            @RequestParam(defaultValue = "") String position){
        return employeeService.getEmployeeSearchInfoAdmin(firstName, lastName, position);
    }

}
