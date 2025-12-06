package com.javalearning.employeemanagemnetsystem.user.service.impl;

import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;
import com.javalearning.employeemanagemnetsystem.position.repository.jdbc.PositionJdbcRepository;
import com.javalearning.employeemanagemnetsystem.position.repository.jpa.PositionJpaRepository;
import com.javalearning.employeemanagemnetsystem.position.service.PositionService;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Position;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Team;
import com.javalearning.employeemanagemnetsystem.shared.data.model.User;
import com.javalearning.employeemanagemnetsystem.team.repository.jdbc.TeamJdbcRepository;
import com.javalearning.employeemanagemnetsystem.team.repository.jpa.TeamJpaRepository;
import com.javalearning.employeemanagemnetsystem.user.dto.CreateUserRequest;
import com.javalearning.employeemanagemnetsystem.user.dto.UpdateUserRequest;
import com.javalearning.employeemanagemnetsystem.user.dto.UpdateUserStatusRequest;
import com.javalearning.employeemanagemnetsystem.user.dto.UserResponse;
import com.javalearning.employeemanagemnetsystem.user.repository.jdbc.UserJdbcRepository;
import com.javalearning.employeemanagemnetsystem.user.repository.jpa.UserJpaRepository;
import com.javalearning.employeemanagemnetsystem.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserJdbcRepository userJdbcRepository;
    private final UserJpaRepository userJpaRepository;
    private final PositionJpaRepository positionJpaRepository;
    private final PositionJdbcRepository positionJdbcRepository;
    private final TeamJdbcRepository teamJdbcRepository;
    private final TeamJpaRepository teamJpaRepository;

    @Override
    public UserResponse createUser(CreateUserRequest userRequest) {
        Position position = positionJpaRepository.findById(userRequest.getPositionId()).orElseThrow(
                () -> new RuntimeException("Position with id number " + userRequest.getPositionId() + " does not exist")
        );

        Team team = teamJpaRepository.findById(userRequest.getTeamId()).orElseThrow(
                () -> new RuntimeException("Team with id number " + userRequest.getTeamId() + " doesn't exist")
        );

        User user = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .code(userRequest.getCode())
                .position(position)
                .team(team)
                .build();

        User savedUser = userJpaRepository.save(user);
        PositionResponse positionResponse =positionJdbcRepository.findById(savedUser.getPosition().getId());

        UserResponse userResponse= UserResponse.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .code(savedUser.getCode())
                .position(positionResponse)
                .team(teamJdbcRepository.findById(savedUser.getTeam().getId()))
                .build();

        return userResponse;
    }

    @Override
    public void deleteUserById(Long id) {
        if(!userJpaRepository.existsById(id)){
            throw new RuntimeException("User with id: " + id + " doesn't exist");
        }
        userJpaRepository.deleteById(id);
    }

    @Override
    public UserResponse updateUserById(Long id, UpdateUserRequest userRequest) {
        if (!userJpaRepository.existsById(id)){
            throw new RuntimeException("User with id: " + id + " does not exist");
        }

        Position position = positionJpaRepository.findById(userRequest.getPositionId()).orElseThrow(
                () -> new RuntimeException("Position with id number " + userRequest.getPositionId() + " does not exist")
        );

        Team team = teamJpaRepository.findById(userRequest.getTeamId()).orElseThrow(
                () -> new RuntimeException("Team with id number " + userRequest.getTeamId() + " doesn't exist")
        );

        User user = User.builder()
                .id(id)
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .email(userRequest.getEmail())
                .code(userRequest.getCode())
                .position(position)
                .team(team)
                .build();

        User updatedUser = userJpaRepository.save(user);

        return UserResponse.builder()
                .id(updatedUser.getId())
                .username(updatedUser.getUsername())
                .password(updatedUser.getPassword())
                .email(updatedUser.getEmail())
                .code(updatedUser.getCode())
                .position(positionJdbcRepository.findById(updatedUser.getPosition().getId()))
                .team(teamJdbcRepository.findById(updatedUser.getTeam().getId()))
                .build();
    }


    @Override
    public List<UserResponse> retrieveAllUsers() {
        return userJdbcRepository.findALlUsers();
    }

    @Override
    public UserResponse retrieveUserById(Long id) {
        return userJdbcRepository.findUserById(id);
    }

    @Override
    public void updateUserStatusId(Long id, UpdateUserStatusRequest updateUserStatusRequest) {
        if (!userJpaRepository.existsById(id)){
            throw new RuntimeException("User with id: " + id + " does not exist");
        }
        userJdbcRepository.updateUserStatus(id, updateUserStatusRequest.getStatusId());
    }
}
