package com.javalearning.employeemanagemnetsystem.team.controller;

import com.javalearning.employeemanagemnetsystem.team.dto.TeamTemplateResponse;
import com.javalearning.employeemanagemnetsystem.shared.data.enums.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees/teams")
public class TeamController {

    @GetMapping("/template")
    public TeamTemplateResponse getTeamTemplate(){
        return new TeamTemplateResponse(
                Status.listInfo()
        );
    }
}
