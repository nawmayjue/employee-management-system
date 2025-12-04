package com.javalearning.employeemanagemnetsystem.team.service.impl;

import com.javalearning.employeemanagemnetsystem.department.repository.jdbc.DepartmentJdbcRepository;
import com.javalearning.employeemanagemnetsystem.department.repository.jpa.DepartmentJpaRepository;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Department;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Team;
import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import com.javalearning.employeemanagemnetsystem.team.dto.CreateTeamRequest;
import com.javalearning.employeemanagemnetsystem.team.dto.UpdateTeamRequest;
import com.javalearning.employeemanagemnetsystem.team.dto.UpdateTeamStatusRequest;
import com.javalearning.employeemanagemnetsystem.team.repository.jdbc.TeamJdbcRepository;
import com.javalearning.employeemanagemnetsystem.team.repository.jpa.TeamJpaRepository;
import com.javalearning.employeemanagemnetsystem.team.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamJpaRepository teamJpaRepository;
    private final DepartmentJpaRepository departmentJpaRepository;
    private final DepartmentJdbcRepository departmentJdbcRepository;
    private final TeamJdbcRepository teamJdbcRepository;

    @Override
    public TeamResponse createTeam(CreateTeamRequest teamRequest) {

        Department department = departmentJpaRepository.findById(teamRequest.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id:" + teamRequest.getDepartmentId()));

        Team team = Team.builder()
                .name(teamRequest.getName())
                .code(teamRequest.getCode())
                .department(department)
                .build();

        Team savedTeam = teamJpaRepository.save(team);

        return TeamResponse.builder()
                    .id(savedTeam.getId())
                    .name(savedTeam.getName())
                    .code(savedTeam.getCode())
                    .department(
                            departmentJdbcRepository.findById(savedTeam.getDepartment().getId())
                    )
                    .build();
    }

    @Override
    public List<TeamResponse> retrieveAllTeams() {
        return teamJdbcRepository.findAll();
    }

    @Override
    public TeamResponse retrieveTeamById(Long id) {
        return teamJdbcRepository.findById(id);
    }

    @Override
    public void deleteTeamById(Long id) {
        if (!teamJpaRepository.existsById(id)){
            throw new RuntimeException("Team with id: " + id + " does not exist");
        }
        teamJpaRepository.deleteById(id);
    }

    @Override
    public TeamResponse updateTeamById(Long id, UpdateTeamRequest updateTeamRequest) {
        if (!teamJpaRepository.existsById(id)){
            throw new RuntimeException("Team with id: " + id + " does not exist");
        }
        if (!departmentJpaRepository.existsById(updateTeamRequest.getDepartmentId())){
            throw new RuntimeException("Department with id: " + updateTeamRequest.getDepartmentId() + " does not exist");
        }

        Department department = departmentJpaRepository.findById(updateTeamRequest.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id:" + updateTeamRequest.getDepartmentId()));

        Team team = Team.builder()
                        .id(id)
                        .name(updateTeamRequest.getName())
                        .code(updateTeamRequest.getCode())
                        .department(department)
                        .build();

        Team updatedTeam = teamJpaRepository.save(team);

        return TeamResponse.builder()
                .id(updatedTeam.getId())
                .name(updatedTeam.getName())
                .code(updatedTeam.getCode())
                .department(
                        departmentJdbcRepository.findById(updatedTeam.getDepartment().getId())
                )
                .build();
    }

    @Override
    public void updateTeamStatusById(Long id, UpdateTeamStatusRequest updateTeamStatusRequest) {
        if (!teamJpaRepository.existsById(id)){
            throw new RuntimeException("Team with id: " + id + " does not exist");
        }
        teamJdbcRepository.updateStatus(id, updateTeamStatusRequest.getStatusId());
    }
}
