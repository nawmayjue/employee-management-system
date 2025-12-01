package com.javalearning.employeemanagemnetsystem.position.service.impl;

import com.javalearning.employeemanagemnetsystem.position.dto.CreatePositionRequest;
import com.javalearning.employeemanagemnetsystem.position.dto.PositionResponse;
import com.javalearning.employeemanagemnetsystem.position.dto.UpdatePositionRequest;
import com.javalearning.employeemanagemnetsystem.position.dto.UpdatePositionStatusRequest;
import com.javalearning.employeemanagemnetsystem.position.service.PositionService;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Position;
import com.javalearning.employeemanagemnetsystem.position.repository.jdbc.PositionJdbcRepository;
import com.javalearning.employeemanagemnetsystem.position.repository.jpa.PositionJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionJpaRepository positionRepository;
    private final PositionJdbcRepository positionJdbcRepository;

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

    @Override
    public List<PositionResponse> retrieveAll() {
        return positionJdbcRepository.findAll();
    }

    @Override
    public PositionResponse retrievePositionById(Long id) {
        return positionJdbcRepository.findById(id);
    }

    @Override
    public PositionResponse updatePositionById(Long id, UpdatePositionRequest updatePositionRequest) {
        PositionResponse positionResponse = positionJdbcRepository.findById(id);
        Position position = Position.builder()
                .id(positionResponse.getId())
                .name(updatePositionRequest.getName())
                .code(updatePositionRequest.getCode())
                .build();
        Position updatedPosition = positionRepository.save(position);
        return PositionResponse.builder()
                .id(updatedPosition.getId())
                .name(updatedPosition.getName())
                .code(updatedPosition.getCode())
                .build();
    }

    @Override
    public void deletePositionById(Long id) {
        if (positionRepository.existsById(id)) {
            positionRepository.deleteById(id);
        }
    }

    @Override
    public PositionResponse updatePositionStatus(Long id, UpdatePositionStatusRequest updatePositionStatusRequest) {
        PositionResponse position = positionJdbcRepository.findById(id);
        return null;
    }


}
