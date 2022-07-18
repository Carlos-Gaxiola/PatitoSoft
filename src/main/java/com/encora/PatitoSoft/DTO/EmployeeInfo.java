package com.encora.PatitoSoft.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeInfo {
    String corporateEmail;
    String firstName;
    String lastName;
    String personalEmail;
    String phoneNumber;
    LocalDate birthday;
    String street;
    String number;
    String zipcode;
    String gender;
    String state;
    String country;
}
