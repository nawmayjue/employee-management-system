package com.javalearning.employeemanagemnetsystem.feedback.mapper;

import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackResponse;
import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;
import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import com.javalearning.employeemanagemnetsystem.user.dto.UserResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackRowMapper implements RowMapper<FeedbackResponse> {
    @Override
    public FeedbackResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FeedbackResponse(
                rs.getLong("feedbackId"),
                rs.getString("feedbackMessage"),
                new UserResponse(
                        rs.getLong("fromUserId"),
                        rs.getString("fromUsername")),
                new UserResponse(
                        rs.getLong("toUserId"),
                        rs.getString("toUserName"))
        );
    }
}
