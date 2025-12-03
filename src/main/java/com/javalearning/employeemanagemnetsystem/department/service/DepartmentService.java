package com.javalearning.employeemanagemnetsystem.department.service;

import com.javalearning.employeemanagemnetsystem.department.dto.CreateDepartmentRequest;
import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse createDepartment(CreateDepartmentRequest departmentRequest);
    List<DepartmentResponse> retrieveAll();
}
