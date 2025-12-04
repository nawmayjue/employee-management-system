package com.javalearning.employeemanagemnetsystem.department.mapper;

import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper<DepartmentResponse>{
    @Override
    public DepartmentResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DepartmentResponse(
                rs.getLong("departmentId"),
                rs.getString("departmentName"),
                rs.getString("departmentCode"),
                new DivisionResponse(
                        rs.getLong("divisionId"),
                        rs.getString("divisionName"),
                        rs.getString("divisionCode")
                )
        );
    }
}
