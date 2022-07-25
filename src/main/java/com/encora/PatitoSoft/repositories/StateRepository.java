package com.encora.PatitoSoft.repositories;

import com.encora.PatitoSoft.entities.State;
import com.encora.PatitoSoft.repositories.projections.EmployeeGenders;
import com.encora.PatitoSoft.repositories.projections.EmployeeLocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Integer> {

    @Query(
            value = """
                SELECT id FROM state WHERE state_name = ?;
            """,
            nativeQuery = true
    )
    State findStateByName(String state);

    @Query(
            value = """
                SELECT COUNT(id_state) AS employeesInThisState, state.state_name AS stateLocation
                FROM employee 
                LEFT JOIN state ON employee.id_state = state.id 
                WHERE state.id_country = (SELECT id FROM country WHERE country_name = :country) 
                GROUP BY state.state_name;
            """,
            nativeQuery = true
    )
    List<EmployeeLocations> employeeLocationsReport(@Param("country") String country);
}
