package com.javalearning.employeemanagemnetsystem.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserStatusResponse {
    private Integer statusId;
    private String statusInfo;
}
