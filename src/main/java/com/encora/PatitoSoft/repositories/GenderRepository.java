package com.encora.PatitoSoft.repositories;

import com.encora.PatitoSoft.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
    @Query(
            value = """
                SELECT id FROM gender WHERE gender_name = ?;
            """,
            nativeQuery = true
    )
    Gender findGenderByName(String name);
}
