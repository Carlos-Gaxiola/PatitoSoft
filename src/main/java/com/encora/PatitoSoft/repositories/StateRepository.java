package com.encora.PatitoSoft.repositories;

import com.encora.PatitoSoft.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StateRepository extends JpaRepository<State, Integer> {

    @Query(
            value = """
                SELECT id FROM state WHERE state_name = ?;
            """,
            nativeQuery = true
    )
    State findStateByName(String state);
}
