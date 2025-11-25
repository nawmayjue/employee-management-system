package com.javalearning.employeemanagemnetsystem.position.service.impl;

import com.javalearning.employeemanagemnetsystem.position.dto.CreatePositionRequest;
import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;
import com.javalearning.employeemanagemnetsystem.position.service.PositionService;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Position;
import com.javalearning.employeemanagemnetsystem.shared.data.repository.jpa.PositionJpaRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionJpaRepository positionRepository;

    @Override
    public PositionResponse createPosition(CreatePositionRequest positionRequest) {
        Position position = Position.builder()
                .name(positionRequest.getName())
                .build();

        Position savedPosition = positionRepository.save(position);

        return PositionResponse.builder()
                .id(savedPosition.getId())
                .name(savedPosition.getName())
                .build();
    }
}
