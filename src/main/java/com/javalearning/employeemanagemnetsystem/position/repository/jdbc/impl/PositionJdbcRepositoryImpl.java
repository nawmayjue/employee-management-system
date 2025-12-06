package com.javalearning.employeemanagemnetsystem.position.repository.jdbc.impl;

import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;
import com.javalearning.employeemanagemnetsystem.position.mapper.PositionRowMapper;
import com.javalearning.employeemanagemnetsystem.position.repository.jdbc.PositionJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PositionJdbcRepositoryImpl implements PositionJdbcRepository {
    private static final PositionRowMapper POSITION_ROW_MAPPER = new PositionRowMapper();
    private final JdbcTemplate jdbcTemplate;

    private static final String FIND_BY_ID_QUERY= """
            SELECT id, name, code FROM position WHERE id=?
            """;

    private static final String FIND_ALL_QUERY = """
            SELECT id, name, code FROM position
            """;

    @Override
    public List<PositionResponse> findAll() {
        return this.jdbcTemplate.query(
                FIND_ALL_QUERY,
                POSITION_ROW_MAPPER
        );
    }

    @Override
    public PositionResponse findById(Long id) {
        return jdbcTemplate.queryForObject(
                FIND_BY_ID_QUERY,
                POSITION_ROW_MAPPER,
                id
        );
    }
}
