package com.javalearning.employeemanagemnetsystem.division.mapper;

import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionRowMapper implements RowMapper<DivisionResponse> {
    @Override
    public DivisionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DivisionResponse(
          rs.getLong("id"),
          rs.getString("name"),
          rs.getString("code")
        );
    }
}
