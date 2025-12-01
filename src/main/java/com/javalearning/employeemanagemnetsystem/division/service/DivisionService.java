package com.javalearning.employeemanagemnetsystem.division.service;

import com.javalearning.employeemanagemnetsystem.division.dto.CreateDivisionRequest;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import com.javalearning.employeemanagemnetsystem.division.dto.UpdateDivisionRequest;
import com.javalearning.employeemanagemnetsystem.division.dto.UpdateDivisionStatusRequest;

import java.util.List;

public interface DivisionService {
    public DivisionResponse createDivision(CreateDivisionRequest divisionRequest);
    List<DivisionResponse> retrieveAllDivision();
    public DivisionResponse retrieveById(Long id);
    public DivisionResponse updateById(Long id, UpdateDivisionRequest updateDivisionRequest);
    public DivisionResponse updateDivisionStatusById(Long id, UpdateDivisionStatusRequest divisionRequest);
    void deleteDivisionById(Long id);
}
