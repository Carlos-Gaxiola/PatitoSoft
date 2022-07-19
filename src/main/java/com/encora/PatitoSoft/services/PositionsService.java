package com.encora.PatitoSoft.services;

import com.encora.PatitoSoft.DTO.EmployeeInfo;

import com.encora.PatitoSoft.repositories.CountryRepository;
import com.encora.PatitoSoft.repositories.EmployeePositionRepository;
import com.encora.PatitoSoft.repositories.projections.EmployeePositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionsService {
    @Autowired
    EmployeePositionRepository employeePositionRepository;
    public List<EmployeePositions> findEmployeesPositions() {
        return employeePositionRepository.findEmployeesPositions();
    }
}
