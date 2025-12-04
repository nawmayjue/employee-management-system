package com.javalearning.employeemanagemnetsystem.division.service;

import com.javalearning.employeemanagemnetsystem.division.dto.CreateDivisionRequest;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import com.javalearning.employeemanagemnetsystem.division.dto.UpdateDivisionRequest;
import com.javalearning.employeemanagemnetsystem.division.dto.UpdateDivisionStatusRequest;

import java.util.List;

public interface DivisionService {
    DivisionResponse createDivision(CreateDivisionRequest divisionRequest);
    List<DivisionResponse> retrieveAllDivision();
    DivisionResponse retrieveById(Long id);
    DivisionResponse updateById(Long id, UpdateDivisionRequest updateDivisionRequest);
    void updateDivisionStatusById(Long id, UpdateDivisionStatusRequest divisionRequest);
    void deleteDivisionById(Long id);
}
