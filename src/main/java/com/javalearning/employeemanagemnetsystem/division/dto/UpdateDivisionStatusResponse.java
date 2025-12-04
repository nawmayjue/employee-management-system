package com.javalearning.employeemanagemnetsystem.division.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateDivisionStatusResponse {
    private Integer statusId;
    private String statusInfo;
}
