package com.javalearning.employeemanagemnetsystem.team.service;

import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import com.javalearning.employeemanagemnetsystem.team.dto.CreateTeamRequest;
import com.javalearning.employeemanagemnetsystem.team.dto.UpdateTeamRequest;
import com.javalearning.employeemanagemnetsystem.team.dto.UpdateTeamStatusRequest;

import java.util.List;

public interface TeamService {
    TeamResponse createTeam(CreateTeamRequest teamRequest);
    List<TeamResponse> retrieveAllTeams();
    TeamResponse retrieveTeamById(Long id);
    void deleteTeamById(Long id);
    TeamResponse updateTeamById(Long id, UpdateTeamRequest updateTeamRequest);
    void updateTeamStatusById(Long id, UpdateTeamStatusRequest updateTeamStatusRequest);
}
