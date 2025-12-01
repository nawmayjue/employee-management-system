package com.javalearning.employeemanagemnetsystem.division.repository.jdbc;

import com.javalearning.employeemanagemnetsystem.division.dto.DivisionResponse;

import java.util.List;


public interface DivisionJdbcRepository {
    List<DivisionResponse> findAll();
    public DivisionResponse findById(Long id);
    public DivisionResponse updateStatus(Long id, String code);

}
