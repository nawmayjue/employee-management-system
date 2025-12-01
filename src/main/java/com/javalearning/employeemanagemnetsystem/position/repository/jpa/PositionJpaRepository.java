package com.javalearning.employeemanagemnetsystem.shared.data.repository.jpa;

import com.javalearning.employeemanagemnetsystem.shared.data.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionJpaRepository extends JpaRepository<Position, Long> {
}
