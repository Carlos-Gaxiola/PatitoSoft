package com.encora.PatitoSoft.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="Employee")
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "corporate_email", nullable = false, unique = true, length = 256)
    private String corporateEmail;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "personal_email", unique = true, length = 256)
    private String personalEmail;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "street", nullable = false, length = 50)
    private String street;

    @Column(name = "number", nullable = false, length = 10)
    private String number;

    @Column(name = "zipcode", nullable = false, length = 10)
    private String zipcode;

    @Column(name = "is_former_employee", nullable = false, columnDefinition = "boolean default 0")
    private boolean is_former_employee;

    @ManyToOne(optional=false)
    @JoinColumn(name = "id_gender", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Gender gender;

    @ManyToOne(optional=false)
    @JoinColumn(name = "id_state", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private State state;

    @ManyToOne(optional=false)
    @JoinColumn(name = "id_country", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Country country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorporateEmail() {
        return corporateEmail;
    }

    public void setCorporateEmail(String corporateEmail) {
        this.corporateEmail = corporateEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isIs_former_employee() {
        return is_former_employee;
    }

    public void setIs_former_employee(boolean is_former_employee) {
        this.is_former_employee = is_former_employee;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Employee() {
    }
}
