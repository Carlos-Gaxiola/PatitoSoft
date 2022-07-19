package com.encora.PatitoSoft.repositories;

import com.encora.PatitoSoft.entities.EmployeePosition;
import com.encora.PatitoSoft.repositories.projections.EmployeePositions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePositionRepository extends JpaRepository<EmployeePosition, Integer> {
    @Query(
            value = """
                SELECT position_name AS positionName, COUNT(id_employee) AS numberOfEmployees 
                FROM work_position 
                LEFT JOIN employee_position ON work_position.id = employee_position.id_work_position 
                WHERE is_current_position = 1 
                GROUP by position_name;
            """,
            nativeQuery = true
    )
    List<EmployeePositions> findEmployeesPositions();
}
