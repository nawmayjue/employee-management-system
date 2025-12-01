package com.javalearning.employeemanagemnetsystem.division.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDivisionRequest {
    private String name;
    private String code;
}
