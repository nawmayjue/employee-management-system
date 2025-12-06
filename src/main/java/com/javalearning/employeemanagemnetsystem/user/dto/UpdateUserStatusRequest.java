package com.javalearning.employeemanagemnetsystem.user.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserStatusRequest {
    private Integer statusId;
}
