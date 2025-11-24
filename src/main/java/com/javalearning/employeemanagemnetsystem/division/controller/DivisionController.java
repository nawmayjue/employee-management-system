package com.javalearning.employeemanagemnetsystem.division.controller;

import com.javalearning.employeemanagemnetsystem.division.dto.CreateDivisionRequest;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import com.javalearning.employeemanagemnetsystem.division.dto.DivisionTemplateResponse;
import com.javalearning.employeemanagemnetsystem.shared.data.enums.Status;
import com.javalearning.employeemanagemnetsystem.division.service.DivisionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees/divisions")
public class DivisionController {

    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @GetMapping("/template")
    public DivisionTemplateResponse getDivisionTemplate(){
        return new DivisionTemplateResponse(
                Status.listInfo()
        );
    }

    @PostMapping
    public DivisionResponse createDivision(
            @RequestBody CreateDivisionRequest createDivisionRequest
    ){
        return divisionService.createDivision(createDivisionRequest);
    }
}
