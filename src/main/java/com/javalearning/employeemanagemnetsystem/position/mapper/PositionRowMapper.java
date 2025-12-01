package com.javalearning.employeemanagemnetsystem.position.mapper;

import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionRowMapper implements RowMapper<PositionResponse> {
    @Override
    public PositionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PositionResponse(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("code")
        );
    }
}
