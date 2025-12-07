package com.javalearning.employeemanagemnetsystem.feedback.repository.jdbc.impl;

import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackResponse;
import com.javalearning.employeemanagemnetsystem.feedback.mapper.FeedbackRowMapper;
import com.javalearning.employeemanagemnetsystem.feedback.repository.jdbc.FeedbackJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FeedbackJdbcRepositoryImpl implements FeedbackJdbcRepository {
    private static final FeedbackRowMapper FEEDBACK_ROW_MAPPER = new FeedbackRowMapper();
    private final JdbcTemplate jdbcTemplate;

    private static final String FIND_ALL_QUERY = """
            SELECT
                f.id AS feedbackId,
                f.message AS feedbackMessage,
                uf.id AS fromUserId,
                uf.username AS fromUsername,
                ut.id AS toUserId,
                ut.username AS toUserName
            FROM feedback f
            JOIN user uf ON uf.id=f.from_user_id
            JOIN user ut ON ut.id=f.to_user_id
            """;

    private static final String FIND_BY_ID_QUERY= """
            SELECT
                f.id AS feedbackId,
                f.message AS feedbackMessage,
                uf.id AS fromUserId,
                uf.username AS fromUsername,
                ut.id AS toUserId,
                ut.username AS toUserName
            FROM feedback f
            JOIN user uf ON u.id=f.from_user_id
            JOIN user ut ON ut.id=f.to_user_id
            WHERE f.id=?
            """;

    @Override
    public List<FeedbackResponse> findAll() {
        return this.jdbcTemplate.query(
                FIND_ALL_QUERY,
                FEEDBACK_ROW_MAPPER
        );
    }

    @Override
    public FeedbackResponse findById(Long id) {
        return this.jdbcTemplate.queryForObject(
                FIND_BY_ID_QUERY,
                FEEDBACK_ROW_MAPPER,
                id
        );
    }
}
