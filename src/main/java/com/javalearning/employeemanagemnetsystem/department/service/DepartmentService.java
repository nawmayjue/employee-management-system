package com.javalearning.employeemanagemnetsystem.department.service;

import com.javalearning.employeemanagemnetsystem.department.dto.CreateDepartmentRequest;
import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;
import com.javalearning.employeemanagemnetsystem.department.dto.UpdateDepartmentRequest;
import com.javalearning.employeemanagemnetsystem.division.dto.UpdateDepartmentStatusRequest;
import com.javalearning.employeemanagemnetsystem.division.dto.UpdateDivisionStatusRequest;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse createDepartment(CreateDepartmentRequest departmentRequest);
    List<DepartmentResponse> retrieveAll();
    DepartmentResponse retrieveById(Long id);
    DepartmentResponse updateDepartment(Long id, UpdateDepartmentRequest updateDepartmentRequest);
    void deleteById(Long id);
    void updateStatus(Long id, UpdateDepartmentStatusRequest updateDepartmentStatusRequest);
}
