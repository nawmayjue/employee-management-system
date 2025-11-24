package com.javalearning.employeemanagemnetsystem.division.dto;

import com.javalearning.employeemanagemnetsystem.shared.data.enums.StatusInfo;

import java.util.List;

public record DivisionTemplateResponse (
        List<StatusInfo> statusOptions
){}
