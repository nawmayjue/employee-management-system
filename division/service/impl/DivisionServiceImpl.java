package com.javalearning.employeemanagemnetsystem.division.service.impl;

import com.javalearning.employeemanagemnetsystem.division.dto.CreateDivisionRequest;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Division;
import com.javalearning.employeemanagemnetsystem.shared.data.repository.jdbc.DivisionJpaRepository;
import com.javalearning.employeemanagemnetsystem.division.service.DivisionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DivisionServiceImpl implements DivisionService {

    private final DivisionJpaRepository divisionJpaRepository;

    @Override
    public DivisionResponse createDivision(CreateDivisionRequest divisionRequest) {

        Division division = Division.builder()
                .name(divisionRequest.getName())
                .code(divisionRequest.getCode())
                .build();

        Division savedDivision = divisionJpaRepository.save(division);

        return DivisionResponse.builder()
                .id(savedDivision.getId())
                .name(savedDivision.getName())
                .code(savedDivision.getCode())
                .build();
    }
}
