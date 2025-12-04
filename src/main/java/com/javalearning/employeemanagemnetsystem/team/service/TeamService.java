package com.javalearning.employeemanagemnetsystem.team.service;

import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import com.javalearning.employeemanagemnetsystem.team.dto.CreateTeamRequest;

public interface TeamService {
    TeamResponse createTeam(CreateTeamRequest teamRequest);
}
