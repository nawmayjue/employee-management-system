package com.javalearning.employeemanagemnetsystem.department.repository.jdbc.impl;

import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;
import com.javalearning.employeemanagemnetsystem.department.mapper.DepartmentRowMapper;
import com.javalearning.employeemanagemnetsystem.department.repository.jdbc.DepartmentJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DepartmentJdbcRepositoryImpl implements DepartmentJdbcRepository {

    private static final DepartmentRowMapper DEPARTMENT_ROW_MAPPER = new DepartmentRowMapper();
    private final JdbcTemplate jdbcTemplate;

    private static final String FIND_BY_ALL_QUERY= """
            SELECT dept.id AS departmentId,
            dept.name AS departmentName,
            dept.code AS departmentCode,
            division.id AS divisionId,
            division.name AS divisionName,
            division.code AS divisionCode
            FROM department dept
            JOIN division division ON division.id=dept.division_id
            """;

    @Override
    public List<DepartmentResponse> findAll() {
        return this.jdbcTemplate.query(
                FIND_BY_ALL_QUERY,
                DEPARTMENT_ROW_MAPPER
        );
    }
}
