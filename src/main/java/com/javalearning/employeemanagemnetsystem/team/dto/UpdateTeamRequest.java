package com.javalearning.employeemanagemnetsystem.team.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTeamRequest {
    private String name;
    private String code;
    private Long departmentId;
}
