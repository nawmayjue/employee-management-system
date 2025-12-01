package com.javalearning.employeemanagemnetsystem.position.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePositionRequest {
    private String name;
    private String code;
}
