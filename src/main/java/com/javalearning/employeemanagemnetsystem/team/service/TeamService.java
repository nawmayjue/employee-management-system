package com.javalearning.employeemanagemnetsystem.team.service;

import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import com.javalearning.employeemanagemnetsystem.team.dto.CreateTeamRequest;

import java.util.List;

public interface TeamService {
    TeamResponse createTeam(CreateTeamRequest teamRequest);
    List<TeamResponse> retrieveAllTeams();
    TeamResponse retrieveTeamById(Long id);
    void deleteTeamById(Long id);
}
