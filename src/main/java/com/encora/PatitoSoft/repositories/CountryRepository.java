package com.encora.PatitoSoft.repositories;

import com.encora.PatitoSoft.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(
            value = """
                SELECT id FROM country WHERE country_name = ?;
            """,
            nativeQuery = true
    )
    Country findCountryByName(String country);
}
