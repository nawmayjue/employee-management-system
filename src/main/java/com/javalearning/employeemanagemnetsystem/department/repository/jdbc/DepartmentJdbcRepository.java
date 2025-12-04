package com.javalearning.employeemanagemnetsystem.department.repository.jdbc;

import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentJdbcRepository {
    public List<DepartmentResponse> findAll();
    public DepartmentResponse findById(Long id);
    void updateDepartmentStatus(Long id, Integer statusId);
}
