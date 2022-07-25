package com.encora.PatitoSoft.services;

import com.encora.PatitoSoft.repositories.StateRepository;
import com.encora.PatitoSoft.repositories.projections.EmployeeGenders;
import com.encora.PatitoSoft.repositories.projections.EmployeeLocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatesService {

    @Autowired
    StateRepository stateRepository;

    public List<EmployeeLocations> employeeLocationsReport(String country) {
        return stateRepository.employeeLocationsReport(country);
    }
}
