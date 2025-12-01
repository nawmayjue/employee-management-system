package com.javalearning.employeemanagemnetsystem.position.service;


import com.javalearning.employeemanagemnetsystem.position.dto.CreatePositionRequest;
import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;
import com.javalearning.employeemanagemnetsystem.position.dto.UpdatePositionRequest;
import com.javalearning.employeemanagemnetsystem.position.dto.UpdatePositionStatusRequest;

import java.util.List;

public interface PositionService {
    public PositionResponse createPosition(CreatePositionRequest positionRequest);
    List<PositionResponse> retrieveAll();
    public PositionResponse retrievePositionById(Long id);
    public PositionResponse updatePositionById(Long id, UpdatePositionRequest updatePositionRequest);
    void deletePositionById(Long id);
    public PositionResponse updatePositionStatus(Long id, UpdatePositionStatusRequest updatePositionStatusRequest);

}
