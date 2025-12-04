package com.javalearning.employeemanagemnetsystem.team.mapper;

import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamRowMapper implements RowMapper<TeamResponse> {

    @Override
    public TeamResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TeamResponse(
                rs.getLong("teamId"),
                rs.getString("teamName"),
                rs.getString("teamCode"),
                new DepartmentResponse(
                        rs.getLong("departmentId"),
                        rs.getString("departmentName"),
                        rs.getString("departmentCode"),
                        new DivisionResponse(
                                rs.getLong("divisionId"),
                                rs.getString("divisionName"),
                                rs.getString("divisionCode")
                        )
                )
        );
    }
}
