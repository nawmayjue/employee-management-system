package com.javalearning.employeemanagemnetsystem.position.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UpdateStatusResponse {
    private Integer statusId;
    private String statusInfo;

}
