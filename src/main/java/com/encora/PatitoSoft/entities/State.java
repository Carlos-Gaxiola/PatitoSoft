package com.encora.PatitoSoft.entities;


import javax.persistence.*;

@Entity(name="State")
@Table(name="State")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "state_name", nullable = false, length = 50)
    private String stateName;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_country", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Country country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State() {
    }
}
