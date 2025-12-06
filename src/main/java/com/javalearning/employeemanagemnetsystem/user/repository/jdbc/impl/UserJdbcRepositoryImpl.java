package com.javalearning.employeemanagemnetsystem.user.repository.jdbc.impl;

import com.javalearning.employeemanagemnetsystem.user.dto.UserResponse;
import com.javalearning.employeemanagemnetsystem.user.mapper.UserRowMapper;
import com.javalearning.employeemanagemnetsystem.user.repository.jdbc.UserJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@AllArgsConstructor
@Repository
public class UserJdbcRepositoryImpl implements UserJdbcRepository {
    private static final UserRowMapper USER_ROW_MAPPER = new UserRowMapper();
    private final JdbcTemplate jdbcTemplate;

    private static String FIND_ALL_QUERY = """
        SELECT 
            u.id AS userId,
            u.username AS username,
            u.password AS userPassword,
            u.email AS userEmail,
            u.code AS userCode,
            p.id AS positionId,
            p.name AS positionName,
            p.code AS positionCode,
            t.id AS teamId,
            t.name AS teamName,
            t.code AS teamCode,
            dep.id AS departmentId,
            dep.name AS departmentName,
            dep.code AS departmentCode,
            division.id AS divisionId,
            division.name AS divisionName,
            division.code AS divisionCode
        FROM user u
        JOIN position p ON p.id=u.position_id
        JOIN team t ON t.id=u.team_id
        JOIN department dep ON dep.id=t.department_id
        JOIN division division ON division.id=dep.division_id
            """;

    private static final String FIND_BY_ID_QUERY = """
       SELECT 
            u.id AS userId,
            u.username AS username,
            u.password AS userPassword,
            u.email AS userEmail,
            u.code AS userCode,
            p.id AS positionId,
            p.name AS positionName,
            p.code AS positionCode,
            t.id AS teamId,
            t.name AS teamName,
            t.code AS teamCode,
            dep.id AS departmentId,
            dep.name AS departmentName,
            dep.code AS departmentCode,
            division.id AS divisionId,
            division.name AS divisionName,
            division.code AS divisionCode
        FROM user u
        JOIN position p ON p.id=u.position_id
        JOIN team t ON t.id=u.team_id
        JOIN department dep ON dep.id=t.department_id
        JOIN division division ON division.id=dep.division_id
        WHERE u.id=?
            """;

    private static final String UPDATE_USER_STATUS_QUERY = """
            UPDATE user SET status_id=? WHERE id=?
            """;

    @Override
    public List<UserResponse> findALlUsers() {
        return this.jdbcTemplate.query(
                FIND_ALL_QUERY,
                USER_ROW_MAPPER
        );
    }

    @Override
    public UserResponse findUserById(Long id) {
        return this.jdbcTemplate.queryForObject(
                FIND_BY_ID_QUERY,
                USER_ROW_MAPPER,
                id
        );
    }

    @Override
    public void updateUserStatus(Long id, Integer statusId) {
        this.jdbcTemplate.update(
                UPDATE_USER_STATUS_QUERY,
                statusId,
                id
        );
    }
}
