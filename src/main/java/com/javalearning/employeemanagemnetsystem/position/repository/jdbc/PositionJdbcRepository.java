package com.javalearning.employeemanagemnetsystem.position.repository.jdbc;

import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;

import java.util.List;

public interface PositionJdbcRepository {
    List<PositionResponse> findAll();
    public PositionResponse findById(Long id);
}
