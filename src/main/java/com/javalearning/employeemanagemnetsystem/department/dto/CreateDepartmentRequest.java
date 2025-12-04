package com.javalearning.employeemanagemnetsystem.department.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDepartmentRequest {
    private String name;
    private String code;
    private Long divisionId;
}