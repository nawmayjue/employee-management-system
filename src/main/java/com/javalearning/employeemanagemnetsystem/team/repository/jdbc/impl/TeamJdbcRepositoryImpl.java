package com.javalearning.employeemanagemnetsystem.team.repository.jdbc.impl;

import com.javalearning.employeemanagemnetsystem.team.TeamResponse;
import com.javalearning.employeemanagemnetsystem.team.mapper.TeamRowMapper;
import com.javalearning.employeemanagemnetsystem.team.repository.jdbc.TeamJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TeamJdbcRepositoryImpl implements TeamJdbcRepository {

    private static final TeamRowMapper TEAM_ROW_MAPPER = new TeamRowMapper();
    private final JdbcTemplate jdbcTemplate;

    private final String FIND_ALL_QUERY = """
        SELECT
            t.id AS teamId,
            t.name AS teamName,
            t.code AS teamCode,
            dept.id AS departmentId,
            dept.name AS departmentName,
            dept.code AS departmentCode,
            division.id AS divisionId,
            division.name AS divisionName,
            division.code AS divisionCode
        FROM team t
        JOIN department dept ON dept.id = t.department_id
        JOIN division division ON division.id = dept.division_id
    """;

    @Override
    public List<TeamResponse> findAll() {
        return jdbcTemplate.query(
                FIND_ALL_QUERY,
                TEAM_ROW_MAPPER
        );
    }
}
