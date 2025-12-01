package com.javalearning.employeemanagemnetsystem.position.controller;

import com.javalearning.employeemanagemnetsystem.position.dto.CreatePositionRequest;
import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;
import com.javalearning.employeemanagemnetsystem.position.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees/propositions")
@AllArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @PostMapping
    public PositionResponse createPosition(
            @RequestBody CreatePositionRequest createPositionRequest
    )
    {return positionService.createPosition(createPositionRequest);}


}
