package com.javalearning.employeemanagemnetsystem.division.repository.jdbc.impl;

import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;
import com.javalearning.employeemanagemnetsystem.division.mapper.DivisionRowMapper;
import com.javalearning.employeemanagemnetsystem.division.repository.jdbc.DivisionJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DivisionJdbcRepositoryImpl implements DivisionJdbcRepository {
    private static final DivisionRowMapper DIVISION_ROW_MAPPER= new DivisionRowMapper();
    private final JdbcTemplate jdbcTemplate;

    private static final String FIND_BY_ID_QUERY= """
            SELECT id, name, code from division WHERE id =?
            """;

    private static final String FIND_ALL_QUERY = """
            SELECT id, name, code FROM division
            """;

    private static final String UPDATE_STATUS_QUERY = """
            UPDATE division SET status_id = ? WHERE id = ?
            """;

    @Override
    public List<DivisionResponse> findAll() {
        return this.jdbcTemplate.query(
                FIND_ALL_QUERY,
                DIVISION_ROW_MAPPER
        );
    }

    @Override
    public DivisionResponse findById(Long id) {
        return this.jdbcTemplate.queryForObject(
                FIND_BY_ID_QUERY,
                DIVISION_ROW_MAPPER,
                id
        );
    }

    @Override
    public DivisionResponse updateStatus(Long id, String code) {

        int rows = jdbcTemplate.update(
                UPDATE_STATUS_QUERY,
                code,  // usually status first, depending on SQL
                id
        );

        return jdbcTemplate.queryForObject(
                FIND_BY_ID_QUERY,
                DIVISION_ROW_MAPPER,
                id
        );
    }

}
