package com.encora.PatitoSoft.entities;

import javax.persistence.*;

@Entity(name="Gender")
@Table(name="Gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "gender_name", nullable = false, length = 50)
    private String genderName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public Gender() {
    }
}
