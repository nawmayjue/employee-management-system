package com.javalearning.employeemanagemnetsystem.division.repository.jpa;

import com.javalearning.employeemanagemnetsystem.shared.data.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionJpaRepository extends JpaRepository<Division, Long> {
}
