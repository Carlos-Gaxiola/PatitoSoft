package com.encora.PatitoSoft.repositories;

import com.encora.PatitoSoft.entities.Gender;
import com.encora.PatitoSoft.repositories.projections.EmployeeGenders;
import com.encora.PatitoSoft.repositories.projections.EmployeePositions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
    @Query(
            value = """
                SELECT id FROM gender WHERE gender_name = ?;
            """,
            nativeQuery = true
    )
    Gender findGenderByName(String name);

    @Query(
            value = """
                SELECT gender_name AS genderName, COUNT(employee.id) * 100 / (SELECT COUNT(id) FROM employee WHERE is_former_employee = 0) AS genderPercentage 
                FROM gender 
                INNER JOIN employee ON gender.id = employee.id_gender 
                WHERE employee.is_former_employee = 0 
                GROUP BY gender_name;
            """,
            nativeQuery = true
    )
    List<EmployeeGenders> findEmployeesGenders();
}
