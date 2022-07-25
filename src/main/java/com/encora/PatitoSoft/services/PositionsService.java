package com.encora.PatitoSoft.services;

import com.encora.PatitoSoft.repositories.EmployeePositionRepository;
import com.encora.PatitoSoft.repositories.projections.EmployeePositions;
import com.encora.PatitoSoft.repositories.projections.EmployeeSalaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionsService {
    @Autowired
    EmployeePositionRepository employeePositionRepository;

    public List<EmployeePositions> findEmployeesPositions() {
        return employeePositionRepository.findEmployeesPositions();
    }

    public List<EmployeeSalaries> employeeSalariesReport(int ranges) {
        List<EmployeeSalaries> rangeOfSalaries = new ArrayList<>();

        double minimumEmployeeSalary = employeePositionRepository.minimumEmployeeSalary();
        double maximumEmployeeSalary = employeePositionRepository.maximumEmployeeSalary();
        double differenceBetweenRanges = (maximumEmployeeSalary - minimumEmployeeSalary) / ranges;

        double minimumSalaryInRange = minimumEmployeeSalary - 1;
        double maximumSalaryInRange = minimumEmployeeSalary + differenceBetweenRanges;

        for(int i = 0; i < ranges; i++){
            int totalEmployeesInRange = employeePositionRepository.employeesInRange(minimumSalaryInRange, maximumSalaryInRange);
            double finalMinimumSalaryInRange = minimumSalaryInRange;
            double finalMaximumSalaryInRange = maximumSalaryInRange;
            rangeOfSalaries.add(new EmployeeSalaries() {
                @Override
                public Double getMinimumInRange() {
                    return finalMinimumSalaryInRange;
                }

                @Override
                public Double getMaximumInRange() {
                    return finalMaximumSalaryInRange;
                }

                @Override
                public Integer getEmployeesInRange() {
                    return totalEmployeesInRange;
                }
            });
            minimumSalaryInRange = maximumSalaryInRange;
            maximumSalaryInRange += differenceBetweenRanges;
        }

        return rangeOfSalaries;
    }




}
