package com.encora.PatitoSoft.entities;

import javax.persistence.*;

@Entity(name="WorkPosition")
@Table(name="WorkPosition")
public class WorkPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position_name", nullable = false, unique = true, length = 100)
    private String positionName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public WorkPosition() {
    }
}
