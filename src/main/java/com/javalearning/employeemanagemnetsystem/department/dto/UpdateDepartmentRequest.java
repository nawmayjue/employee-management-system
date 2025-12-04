package com.javalearning.employeemanagemnetsystem.department.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDepartmentRequest {
    private Long id;
    private String name;
    private String code;
    private Long divisionId;
}
