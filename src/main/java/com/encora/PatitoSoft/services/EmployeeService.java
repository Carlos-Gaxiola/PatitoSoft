package com.encora.PatitoSoft.services;

import com.encora.PatitoSoft.entities.Employee;
import com.encora.PatitoSoft.repositories.CountryRepository;
import com.encora.PatitoSoft.repositories.EmployeeRepository;
import com.encora.PatitoSoft.repositories.GenderRepository;
import com.encora.PatitoSoft.repositories.StateRepository;
import com.encora.PatitoSoft.repositories.projections.EmployeeSimpleSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CountryRepository countryRepository;

    public List<Employee> findTodos(){
        return employeeRepository.findAll();
    }

    public List<EmployeeSimpleSearch> getEmployeeSearchInfoAdmin(String firstName, String lastName, String position) {
        return employeeRepository.getEmployeeSearchInfoAdmin(firstName, lastName, position);
    }

    public List<EmployeeSimpleSearch> getEmployeeSearchInfo(String firstName, String lastName, String position) {
        return employeeRepository.getEmployeeSearchInfo(firstName, lastName, position);
    }

    public EmployeeSimpleSearch getEmployeeByEmail(String corporateEmail) {
        return employeeRepository.getEmployeeByEmail(corporateEmail);
    }
}
