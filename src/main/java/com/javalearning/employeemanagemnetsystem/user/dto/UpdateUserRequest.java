package com.javalearning.employeemanagemnetsystem.user.dto;

import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;
import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UpdateUserRequest {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String code;
    private Long teamId;
    private Long positionId;
}
