package com.javalearning.employeemanagemnetsystem.position.service;


import com.javalearning.employeemanagemnetsystem.position.dto.CreatePositionRequest;
import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;

public interface PositionService {
    public PositionResponse createPosition(CreatePositionRequest positionRequest);
}
