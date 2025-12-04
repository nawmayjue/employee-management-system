package com.javalearning.employeemanagemnetsystem.team.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTeamRequest {
    private String name;
    private String code;
    private Long departmentId;
}
