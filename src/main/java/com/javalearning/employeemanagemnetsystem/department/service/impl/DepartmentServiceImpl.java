package com.javalearning.employeemanagemnetsystem.department.service.impl;

import com.javalearning.employeemanagemnetsystem.department.dto.CreateDepartmentRequest;
import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;
import com.javalearning.employeemanagemnetsystem.department.repository.jdbc.DepartmentJdbcRepository;
import com.javalearning.employeemanagemnetsystem.department.repository.jpa.DepartmentJpaRepository;
import com.javalearning.employeemanagemnetsystem.department.service.DepartmentService;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import com.javalearning.employeemanagemnetsystem.division.repository.jpa.DivisionJpaRepository;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Department;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Division;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentJpaRepository departmentJpaRepository;
    private final DivisionJpaRepository divisionJpaRepository;
    private final DepartmentJdbcRepository departmentJdbcRepository;

    @Override
    public DepartmentResponse createDepartment(CreateDepartmentRequest departmentRequest) {
        Division division = divisionJpaRepository.findById(departmentRequest.getDivisionId())
                .orElseThrow(() -> new RuntimeException("Division not found with id:" + departmentRequest.getDivisionId()));

        Department department = Department.builder()
                .name(departmentRequest.getName())
                .code(departmentRequest.getCode())
                .division(division)
                .build();

        Department savedDepartment = departmentJpaRepository.save(department);

        return DepartmentResponse.builder()
                .id(savedDepartment.getId())
                .name(savedDepartment.getName())
                .code(savedDepartment.getCode())
                .division(
                        DivisionResponse.builder()
                                .id(savedDepartment.getDivision().getId())
                                .name(savedDepartment.getDivision().getName())
                                .code(savedDepartment.getDivision().getCode())
                                .build()
                )
                .build();
    }

    @Override
    public List<DepartmentResponse> retrieveAll() {
        return departmentJdbcRepository.findAll();
    }
}
