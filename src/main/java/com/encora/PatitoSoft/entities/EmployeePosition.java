package com.encora.PatitoSoft.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="EmployeePosition")
@Table(name="EmployeePosition")
public class EmployeePosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "salary", nullable = false)
    private double salary;

    @Column(name = "is_current_position", nullable = false, columnDefinition = "boolean default 0")
    private boolean isCurrentPosition;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @ManyToOne(optional=false)
    @JoinColumn(name = "id_employee", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne(optional=false)
    @JoinColumn(name = "id_work_position", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private WorkPosition workPosition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isCurrentPosition() {
        return isCurrentPosition;
    }

    public void setCurrentPosition(boolean currentPosition) {
        isCurrentPosition = currentPosition;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public WorkPosition getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(WorkPosition workPosition) {
        this.workPosition = workPosition;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public EmployeePosition() {
    }
}
