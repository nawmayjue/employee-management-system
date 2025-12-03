package com.javalearning.employeemanagemnetsystem.department.repository.jdbc;

import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentJdbcRepository {
    public List<DepartmentResponse> findAll();
}
