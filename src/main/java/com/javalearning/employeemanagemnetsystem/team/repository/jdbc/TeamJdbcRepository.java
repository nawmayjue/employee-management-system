package com.javalearning.employeemanagemnetsystem.team.repository.jdbc;

import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamJdbcRepository {
    List<TeamResponse> findAll();
    TeamResponse findById(Long id);
    void updateStatus(Long id, Integer statusId);
}
