package com.javalearning.employeemanagemnetsystem.user.repository.jdbc;

import com.javalearning.employeemanagemnetsystem.shared.data.model.User;
import com.javalearning.employeemanagemnetsystem.user.dto.UserResponse;

import java.util.List;

public interface UserJdbcRepository {
    List<UserResponse> findALlUsers();
    public UserResponse findUserById(Long id);
    void updateUserStatus (Long id, Integer statusId);
}
