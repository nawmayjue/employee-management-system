package com.javalearning.employeemanagemnetsystem.division.service.impl;

import com.javalearning.employeemanagemnetsystem.division.dto.*;
import com.javalearning.employeemanagemnetsystem.shared.data.enums.Status;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Division;
import com.javalearning.employeemanagemnetsystem.division.repository.jdbc.DivisionJdbcRepository;
import com.javalearning.employeemanagemnetsystem.division.repository.jpa.DivisionJpaRepository;
import com.javalearning.employeemanagemnetsystem.division.service.DivisionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DivisionServiceImpl implements DivisionService {

    private final DivisionJpaRepository divisionJpaRepository;
    private final DivisionJdbcRepository divisionJdbcRepository;

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

    @Override
    public List<DivisionResponse> retrieveAllDivision() {
        return divisionJdbcRepository.findAll();
    }

    @Override
    public DivisionResponse retrieveById(Long id) {
        return divisionJdbcRepository.findById(id);
    }

    @Override
    public DivisionResponse updateById(Long id, UpdateDivisionRequest updateDivisionRequest) {
        DivisionResponse divisionResponse = divisionJdbcRepository.findById(id);
        Division division = Division.builder()
                .id(divisionResponse.getId())
                .name(updateDivisionRequest.getName())
                .code(updateDivisionRequest.getCode())
                .build();

        Division updatedDivision = divisionJpaRepository.save(division);

        return DivisionResponse.builder()
                .id(updatedDivision.getId())
                .name(updatedDivision.getName())
                .code(updatedDivision.getCode())
                .build();
    }

    @Override
    public void updateDivisionStatusById(Long id, UpdateDivisionStatusRequest divisionRequest) {
            DivisionResponse division = divisionJdbcRepository.findById(id);
            divisionJdbcRepository.updateStatus(division.getId(), divisionRequest.getStatusId());
    }


    @Override
    public void deleteDivisionById(Long id) {
        if(divisionJpaRepository.existsById(id)){
            divisionJpaRepository.deleteById(id);
        }
    }

}
