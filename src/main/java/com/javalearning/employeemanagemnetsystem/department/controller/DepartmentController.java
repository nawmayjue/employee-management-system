package com.javalearning.employeemanagemnetsystem.department.controller;

import com.javalearning.employeemanagemnetsystem.department.dto.CreateDepartmentRequest;
import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentResponse;
import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentTemplateResponse;
import com.javalearning.employeemanagemnetsystem.department.service.DepartmentService;
import com.javalearning.employeemanagemnetsystem.shared.data.enums.Status;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
