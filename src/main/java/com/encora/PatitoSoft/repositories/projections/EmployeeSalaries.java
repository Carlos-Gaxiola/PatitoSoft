package com.encora.PatitoSoft.repositories.projections;

public interface EmployeeSalaries {
    Double getMinimumInRange();
    Double getMaximumInRange();
    Integer getEmployeesInRange();
}
