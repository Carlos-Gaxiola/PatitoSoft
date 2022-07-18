package com.encora.PatitoSoft.services;

import com.encora.PatitoSoft.DTO.EmployeeInfo;
import com.encora.PatitoSoft.entities.Country;
import com.encora.PatitoSoft.entities.Employee;
import com.encora.PatitoSoft.entities.Gender;
import com.encora.PatitoSoft.entities.State;
import com.encora.PatitoSoft.repositories.CountryRepository;
import com.encora.PatitoSoft.repositories.EmployeeRepository;
import com.encora.PatitoSoft.repositories.GenderRepository;
import com.encora.PatitoSoft.repositories.StateRepository;
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

    public Employee save(EmployeeInfo employeeInfo){
        Employee employee = new Employee();

        employee.setCorporateEmail(employeeInfo.getCorporateEmail());
        employee.setFirstName(employeeInfo.getFirstName());
        employee.setLastName(employeeInfo.getLastName());
        employee.setPersonalEmail(employeeInfo.getPersonalEmail());
        employee.setPhoneNumber(employeeInfo.getPhoneNumber());
        employee.setBirthday(employeeInfo.getBirthday());
        employee.setStreet(employeeInfo.getStreet());
        employee.setNumber(employeeInfo.getNumber());
        employee.setZipcode(employeeInfo.getZipcode());

        Gender gender = genderRepository.findGenderByName(employeeInfo.getGender());
        State state = stateRepository.findStateByName(employeeInfo.getState());
        Country country = countryRepository.findCountryByName(employeeInfo.getCountry());

        employee.setGender(gender);
        employee.setState(state);
        employee.setCountry(country);

        employeeRepository.save(employee);
        return employee;
    }
}
