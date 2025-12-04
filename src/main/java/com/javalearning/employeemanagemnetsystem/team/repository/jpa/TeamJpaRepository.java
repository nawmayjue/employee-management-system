package com.javalearning.employeemanagemnetsystem.team.repository.jpa;

import com.javalearning.employeemanagemnetsystem.shared.data.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamJpaRepository extends JpaRepository<Team, Long> {
}
