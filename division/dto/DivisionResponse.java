package com.javalearning.employeemanagemnetsystem.division.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DivisionResponse {
    private Long id;
    private String name;
    private String code;
}
