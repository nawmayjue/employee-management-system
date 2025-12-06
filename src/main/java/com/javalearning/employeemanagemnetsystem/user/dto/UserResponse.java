package com.javalearning.employeemanagemnetsystem.user.dto;

import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;
import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;
import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String code;
    private PositionResponse position;
    private TeamResponse team;

}
