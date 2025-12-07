package com.javalearning.employeemanagemnetsystem.feedback.repository.jdbc;

import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackResponse;

import java.util.List;

public interface FeedbackJdbcRepository {
    public List<FeedbackResponse> findAll();
    public FeedbackResponse findById(Long id);
}
