package com.encora.PatitoSoft.repositories;

import com.encora.PatitoSoft.entities.Employee;
import com.encora.PatitoSoft.repositories.projections.EmployeeSimpleSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(
            value = """
                SELECT e.corporate_email AS corporateMail, e.first_name AS firstName, e.last_name AS lastName, e.personal_email AS personalMail, e.phone_number AS phoneNumber, e.street AS street, e.number AS number, e.zipcode AS zipcode, 
                                                s.state_name AS state, 
                                                c.country_name AS country, 
                                                g.gender_name AS gender, 
                                                wp.position_name AS positionName
                                                FROM employee AS e
                                                LEFT JOIN employee_position AS ep ON e.id = ep.id_employee
                                                LEFT JOIN work_position AS wp ON ep.id_work_position = wp.id
                                                LEFT JOIN gender AS g ON e.id_gender = g.id
                                                LEFT JOIN state AS s ON e.id_state = s.id
                                                LEFT JOIN country AS c ON e.id_country = c.id
                WHERE (first_name LIKE %:firstName% AND last_name LIKE %:lastName% AND position_name LIKE %:position%) AND is_former_employee = 0 AND ep.is_current_position = 1
            """,
            nativeQuery = true
    )
    List<EmployeeSimpleSearch> getEmployeeSearchInfo(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("position") String position);

    @Query(
            value = """
                SELECT employee.first_name AS firstName, employee.last_name AS lastName, (SELECT position_name FROM work_position WHERE work_position.id = employee_position.id_work_position) AS positionName
                FROM employee
                LEFT JOIN employee_position ON employee.id = employee_position.id_employee
                LEFT JOIN work_position ON employee_position.id_work_position = work_position.id
                WHERE (first_name LIKE %:firstName% AND last_name LIKE %:lastName% AND position_name LIKE %:position%)
            """,
            nativeQuery = true
    )
    List<EmployeeSimpleSearch> getEmployeeSearchInfoAdmin(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("position") String position);

    @Query(
            value = """
                SELECT e.corporate_email AS corporateMail, e.first_name AS firstName, e.last_name AS lastName, e.personal_email AS personalMail, e.phone_number AS phoneNumber, e.street AS street, e.number AS number, e.zipcode AS zipcode, 
                                                s.state_name AS state, 
                                                c.country_name AS country, 
                                                g.gender_name AS gender, 
                                                wp.position_name AS positionName
                                                FROM employee AS e
                                                LEFT JOIN employee_position AS ep ON e.id = ep.id_employee
                                                LEFT JOIN work_position AS wp ON ep.id_work_position = wp.id
                                                LEFT JOIN gender AS g ON e.id_gender = g.id
                                                LEFT JOIN state AS s ON e.id_state = s.id
                                                LEFT JOIN country AS c ON e.id_country = c.id
                WHERE corporate_email = :corporateEmail
            """,
            nativeQuery = true
    )
    EmployeeSimpleSearch getEmployeeByEmail(@Param("corporateEmail") String corporateEmail);
}