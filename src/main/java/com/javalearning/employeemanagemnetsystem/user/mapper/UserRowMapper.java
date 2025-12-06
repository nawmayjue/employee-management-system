package com.javalearning.employeemanagemnetsystem.user.mapper;

import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;
import com.javalearning.employeemanagemnetsystem.shared.data.model.User;
import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import com.javalearning.employeemanagemnetsystem.user.dto.UserResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserResponse> {

    @Override
    public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserResponse(
                rs.getLong("userId"),
                rs.getString("username"),
                rs.getString("userPassword"),
                rs.getString("userEmail"),
                rs.getString("userCode"),
                new PositionResponse(
                        rs.getLong("positionId"),
                        rs.getString("positionName"),
                        rs.getString("positionCode")
                ),
                new TeamResponse(
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
                )
        );
    }
}
