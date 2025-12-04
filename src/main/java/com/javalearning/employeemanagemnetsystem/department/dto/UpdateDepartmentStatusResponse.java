package com.javalearning.employeemanagemnetsystem.department.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateDepartmentStatusResponse {
    private Integer statusId;
    private String statusInfo;
}
