package com.javalearning.employeemanagemnetsystem.department.dto;

import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {
    private Long id;
    private String name;
    private String code;
    private DivisionResponse division;
}
