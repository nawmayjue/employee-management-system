package com.javalearning.employeemanagemnetsystem.division.service;

import com.javalearning.employeemanagemnetsystem.division.dto.CreateDivisionRequest;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;

public interface DivisionService {
    public DivisionResponse createDivision(CreateDivisionRequest divisionRequest);
}
