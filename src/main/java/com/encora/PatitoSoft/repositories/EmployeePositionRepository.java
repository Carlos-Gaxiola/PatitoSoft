package com.encora.PatitoSoft.repositories;

import com.encora.PatitoSoft.entities.EmployeePosition;
import com.encora.PatitoSoft.repositories.projections.EmployeePositions;
import com.encora.PatitoSoft.repositories.projections.EmployeeSalaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeePositionRepository extends JpaRepository<EmployeePosition, Integer> {
    @Query(
            value = """
                SELECT position_name AS positionName, COUNT(id_employee) AS numberOfEmployees 
                FROM work_position 
                INNER JOIN employee_position ON work_position.id = employee_position.id_work_position 
                WHERE is_current_position = 1 
                GROUP by position_name;
            """,
            nativeQuery = true
    )
    List<EmployeePositions> findEmployeesPositions();

    @Query(
            value = """
                SELECT MIN(salary) FROM employee_position WHERE is_current_position = 1
            """,
            nativeQuery = true
    )
    Double minimumEmployeeSalary();

    @Query(
            value = """
                SELECT MAX(salary) FROM employee_position WHERE is_current_position = 1
            """,
            nativeQuery = true
    )
    Double maximumEmployeeSalary();

    @Query(
            value = """
                SELECT COUNT(id) FROM employee_position WHERE salary > :minimumEmployeeSalaryInRange AND salary <= :maximumEmployeeSalaryInRange AND is_current_position = 1
            """,
            nativeQuery = true
    )
    int employeesInRange(@Param("minimumEmployeeSalaryInRange") double minimumEmployeeSalaryInRange, @Param("maximumEmployeeSalaryInRange") double maximumEmployeeSalaryInRange);
}
