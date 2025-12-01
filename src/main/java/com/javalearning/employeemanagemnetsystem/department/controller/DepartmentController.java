package com.javalearning.employeemanagemnetsystem.department.controller;

import com.javalearning.employeemanagemnetsystem.department.dto.DepartmentTemplateResponse;
import com.javalearning.employeemanagemnetsystem.shared.data.enums.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees/departments")
public class DepartmentController {

    @GetMapping("/template")
    public DepartmentTemplateResponse getDepartmentTemplate(){
        return new DepartmentTemplateResponse(
                Status.listInfo()
        );
    }
}
