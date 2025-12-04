package com.javalearning.employeemanagemnetsystem.team.controller;

import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import com.javalearning.employeemanagemnetsystem.team.dto.CreateTeamRequest;
import com.javalearning.employeemanagemnetsystem.team.dto.TeamTemplateResponse;
import com.javalearning.employeemanagemnetsystem.shared.data.enums.Status;
import com.javalearning.employeemanagemnetsystem.team.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees/teams")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/template")
    public TeamTemplateResponse getTeamTemplate(){
        return new TeamTemplateResponse(
                Status.listInfo()
        );
    }

    @PostMapping
    public ResponseEntity<TeamResponse> createTeam(
            @RequestBody CreateTeamRequest createTeamRequest
    ){
        TeamResponse teamResponse = teamService.createTeam(createTeamRequest);
        return ResponseEntity.ok().body(teamResponse);
    }

    @GetMapping
    public ResponseEntity<List<TeamResponse>> retrieveAllTeams(){
        return ResponseEntity.ok(teamService.retrieveAllTeams());
    }
}
