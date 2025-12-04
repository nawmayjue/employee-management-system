package com.javalearning.employeemanagemnetsystem.team.dto;

import com.javalearning.employeemanagemnetsystem.shared.data.enums.StatusInfo;

import java.util.List;

public record TeamTemplateResponse(
        List<StatusInfo> statusOptions
) {}
