package com.javalearning.employeemanagemnetsystem.team.controller;

import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import com.javalearning.employeemanagemnetsystem.team.dto.*;
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

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> retrieveTeamById(
            @PathVariable Long id
    ){
        return ResponseEntity.ok().body(teamService.retrieveTeamById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeamById(
            @PathVariable Long id
    ){
        try {
            teamService.deleteTeamById(id);
            return ResponseEntity.ok("Team with ID number " + id + "has been deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamResponse> updateTeamById(
            @PathVariable Long id,
            @RequestBody UpdateTeamRequest updateTeamRequest
    ){
        TeamResponse teamResponse = teamService.updateTeamById(id, updateTeamRequest);
        return ResponseEntity.ok().body(teamResponse);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateTeamStatus(
            @PathVariable Long id,
            @RequestBody UpdateTeamStatusRequest updateTeamStatusRequest
    ){
        try {
            teamService.updateTeamStatusById(id, updateTeamStatusRequest);
            return ResponseEntity.ok(
                    UpdateTeamStatusResponse.builder()
                            .statusId(updateTeamStatusRequest.getStatusId())
                            .statusInfo(String.valueOf(Status.fromCode(updateTeamStatusRequest.getStatusId())))
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
