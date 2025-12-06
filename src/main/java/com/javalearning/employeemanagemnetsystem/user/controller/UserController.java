package com.javalearning.employeemanagemnetsystem.user.controller;


import com.javalearning.employeemanagemnetsystem.shared.data.enums.Status;
import com.javalearning.employeemanagemnetsystem.user.dto.*;
import com.javalearning.employeemanagemnetsystem.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/template")
    public ResponseEntity<UserTemplateResponse> getUserTemplate(){
        return ResponseEntity.ok(new UserTemplateResponse(
                Status.listInfo()
        ));
    }

    @PostMapping
    public UserResponse createUser(
            @RequestBody CreateUserRequest createUserRequest
    ){
        UserResponse userResponse = userService.createUser(createUserRequest);
        return userResponse;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> retrieveAllUsers(){
        return ResponseEntity.ok(userService.retrieveAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> retrieveUserById(
            @PathVariable Long id
    ){
        return ResponseEntity.ok().body(userService.retrieveUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(
            @PathVariable Long id
    ){
        try {
            userService.deleteUserById(id);
            return ResponseEntity.ok("User with ID number " + id + "has been deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUserById(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest updateUserRequest
    ){
        UserResponse userResponse = userService.updateUserById(id, updateUserRequest);
        return ResponseEntity.ok().body(userResponse);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateUserStatus(
            @PathVariable Long id,
            @RequestBody UpdateUserStatusRequest updateUserStatusRequest
    ){
        try {
            userService.updateUserStatusId(id, updateUserStatusRequest);
            return ResponseEntity.ok(
                    UpdateUserStatusResponse.builder()
                            .statusId(updateUserStatusRequest.getStatusId())
                            .statusInfo(String.valueOf(Status.fromCode(updateUserStatusRequest.getStatusId())))
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
