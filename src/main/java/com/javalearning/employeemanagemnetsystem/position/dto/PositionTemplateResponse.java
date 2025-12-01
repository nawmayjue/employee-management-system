package com.javalearning.employeemanagemnetsystem.position.dto;

import com.javalearning.employeemanagemnetsystem.shared.data.enums.StatusInfo;

import java.util.List;

public record PositionTemplateResponse(
        List<StatusInfo> statusOptions
) {}
