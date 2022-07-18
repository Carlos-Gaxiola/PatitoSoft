package com.encora.PatitoSoft.entities;

import javax.persistence.*;

@Entity(name="Country")
@Table(name="Country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country_name", nullable = false, unique = true, length = 40)
    private String countryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Country() {
    }
}
