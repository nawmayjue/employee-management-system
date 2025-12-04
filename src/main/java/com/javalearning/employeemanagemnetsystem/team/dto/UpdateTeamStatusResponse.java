package com.javalearning.employeemanagemnetsystem.team.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTeamStatusResponse {
    private Integer statusId;
    private String statusInfo;
}
