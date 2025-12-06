package com.javalearning.employeemanagemnetsystem.user.dto;

import com.javalearning.employeemanagemnetsystem.shared.data.enums.StatusInfo;

import java.util.List;

public record UserTemplateResponse (
        List<StatusInfo> statusOptions
)
{}
