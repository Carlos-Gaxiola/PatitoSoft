package com.encora.PatitoSoft.services;

import com.encora.PatitoSoft.repositories.GenderRepository;
import com.encora.PatitoSoft.repositories.projections.EmployeeGenders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GendersService {

    @Autowired
    GenderRepository genderRepository;
    public List<EmployeeGenders> findEmployeesGenders() {
        return genderRepository.findEmployeesGenders();
    }
}
