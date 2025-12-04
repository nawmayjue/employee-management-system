package com.javalearning.employeemanagemnetsystem.division.controller;

import com.javalearning.employeemanagemnetsystem.division.dto.*;
import com.javalearning.employeemanagemnetsystem.shared.data.enums.Status;
import com.javalearning.employeemanagemnetsystem.division.service.DivisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<DivisionResponse> retrieveAllDivision(){
        return divisionService.retrieveAllDivision();
    }

    @GetMapping("/{id}")
    public DivisionResponse retrieveDivisionById(
            @PathVariable Long id
    ){
      return divisionService.retrieveById(id);
    }

    @PutMapping("/{id}")
    public DivisionResponse updateDivisionById(
            @PathVariable Long id,
            @RequestBody UpdateDivisionRequest updateDivisionRequest
            ){
        return divisionService.updateById(id, updateDivisionRequest);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateDivisionStatus(
            @PathVariable Long id,
            @RequestBody UpdateDivisionStatusRequest updateDivisionRequest
    ){
        divisionService.updateDivisionStatusById(id, updateDivisionRequest);
        return ResponseEntity.ok(
                UpdateDivisionStatusResponse.builder()
                        .statusId(updateDivisionRequest.getStatusId())
                        .statusInfo(String.valueOf(Status.fromCode(updateDivisionRequest.getStatusId())))
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDivisionById(
            @PathVariable Long id) {
        divisionService.deleteDivisionById(id);
                return ResponseEntity.ok("Successfully deleted User with id number " + id);
    }
}

