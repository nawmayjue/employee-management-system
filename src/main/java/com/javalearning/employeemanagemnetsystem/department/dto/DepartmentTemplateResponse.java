package com.javalearning.employeemanagemnetsystem.department.dto;

import com.javalearning.employeemanagemnetsystem.shared.data.enums.StatusInfo;

import java.util.List;

public record DepartmentTemplateResponse(
        List<StatusInfo> statusOptions
) {}
