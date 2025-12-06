package com.javalearning.employeemanagemnetsystem.user.service;

import com.javalearning.employeemanagemnetsystem.user.dto.CreateUserRequest;
import com.javalearning.employeemanagemnetsystem.user.dto.UpdateUserRequest;
import com.javalearning.employeemanagemnetsystem.user.dto.UpdateUserStatusRequest;
import com.javalearning.employeemanagemnetsystem.user.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUserRequest userRequest);
    void deleteUserById(Long id);
    UserResponse updateUserById(Long id, UpdateUserRequest userRequest);
    List<UserResponse> retrieveAllUsers();
    UserResponse retrieveUserById(Long id);
    void updateUserStatusId(Long id, UpdateUserStatusRequest updateUserStatusRequest);
}
