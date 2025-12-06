package com.javalearning.employeemanagemnetsystem.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {
    private String username;
    private String email;
    private String password;
    private String code;
    private Long teamId;
    private Long positionId;
}
