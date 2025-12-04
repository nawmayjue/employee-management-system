package com.javalearning.employeemanagemnetsystem.department.controller;

import com.javalearning.employeemanagemnetsystem.department.dto.*;
import com.javalearning.employeemanagemnetsystem.department.service.DepartmentService;
import com.javalearning.employeemanagemnetsystem.division.dto.UpdateDepartmentStatusRequest;
import com.javalearning.employeemanagemnetsystem.shared.data.enums.Status;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees/departments")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/template")
    public DepartmentTemplateResponse getDepartmentTemplate(){
        return new DepartmentTemplateResponse(
                Status.listInfo()
        );
    }

    @PostMapping
    public DepartmentResponse createDepartment(
            @RequestBody CreateDepartmentRequest createDepartmentRequest
            ){
        return departmentService.createDepartment(createDepartmentRequest);
    }

    @GetMapping
    public List<DepartmentResponse> retrieveAllDepartment(){
        return departmentService.retrieveAll();
    }

    @GetMapping("/{id}")
    public DepartmentResponse retrieveDepartmentById(
            @PathVariable Long id
    ){
        return departmentService.retrieveById(id);
    }

    @PutMapping("/{id}")
    public DepartmentResponse updateDepartment(
            @PathVariable Long id,
            @RequestBody UpdateDepartmentRequest updateDepartmentRequest
            ){
        return departmentService.updateDepartment(id, updateDepartmentRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartmentById(
            @PathVariable Long id
    ){
        departmentService.deleteById(id);
        return ResponseEntity.ok("Department with ID number " + id + "has been deleted");
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateDepartmentStatus(
            @PathVariable Long id,
            @RequestBody UpdateDepartmentStatusRequest updateDepartmentStatusRequest
    ){
        departmentService.updateStatus(id, updateDepartmentStatusRequest);
        return ResponseEntity.ok(
                UpdateDepartmentStatusResponse.builder()
                        .statusId(updateDepartmentStatusRequest.getStatusId())
                        .statusInfo(String.valueOf(Status.fromCode(updateDepartmentStatusRequest.getStatusId())))
                        .build()

        );
    }
}
