package com.javalearning.employeemanagemnetsystem.department.service.impl;

import com.javalearning.employeemanagemnetsystem.department.dto.CreateDepartmentRequest;
import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;
import com.javalearning.employeemanagemnetsystem.department.dto.UpdateDepartmentRequest;
import com.javalearning.employeemanagemnetsystem.department.repository.jdbc.DepartmentJdbcRepository;
import com.javalearning.employeemanagemnetsystem.department.repository.jpa.DepartmentJpaRepository;
import com.javalearning.employeemanagemnetsystem.department.service.DepartmentService;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import com.javalearning.employeemanagemnetsystem.division.dto.UpdateDepartmentStatusRequest;
import com.javalearning.employeemanagemnetsystem.division.repository.jdbc.DivisionJdbcRepository;
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
    private final DivisionJdbcRepository divisionJdbcRepository;

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
                        divisionJdbcRepository.findById(savedDepartment.getDivision().getId())
                )
                .build();
    }

    @Override
    public List<DepartmentResponse> retrieveAll() {
        return departmentJdbcRepository.findAll();
    }

    @Override
    public DepartmentResponse retrieveById(Long id) {
        return departmentJdbcRepository.findById(id);
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, UpdateDepartmentRequest updateDepartmentRequest) {
        DepartmentResponse departmentResponse = departmentJdbcRepository.findById(id);

        Division division = divisionJpaRepository.findById(updateDepartmentRequest.getDivisionId())
                .orElseThrow(() -> new RuntimeException("Division not found with id:" + updateDepartmentRequest.getDivisionId()));

        Department department = Department.builder()
                .id(departmentResponse.getId())
                .name(updateDepartmentRequest.getName())
                .code(updateDepartmentRequest.getCode())
                .division(division)
                .build();

        Department updatedDepartment= departmentJpaRepository.save(department);

        return DepartmentResponse.builder()
                .id(updatedDepartment.getId())
                .name(updatedDepartment.getName())
                .code(updatedDepartment.getCode())
                .division(
                        divisionJdbcRepository.findById(department.getDivision().getId())
                )
                .build();
    }

    @Override
    public void deleteById(Long id) {
        if (departmentJpaRepository.existsById(id)){
            departmentJpaRepository.deleteById(id);
        }
    }

    @Override
    public void updateStatus(Long id, UpdateDepartmentStatusRequest updateDepartmentStatusRequest) {
        DepartmentResponse departmentResponse = departmentJdbcRepository.findById(id);
        departmentJdbcRepository.updateDepartmentStatus(departmentResponse.getId(), updateDepartmentStatusRequest.getStatusId());

    }


}
