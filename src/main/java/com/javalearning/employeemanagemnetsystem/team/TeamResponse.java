package com.javalearning.employeemanagemnetsystem.team;

import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponse {
    private Long id;
    private String name;
    private String code;
    private DepartmentResponse department;
}
