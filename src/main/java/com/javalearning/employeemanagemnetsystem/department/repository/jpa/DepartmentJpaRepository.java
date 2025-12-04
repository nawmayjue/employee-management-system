package com.javalearning.employeemanagemnetsystem.department.repository.jpa;

import com.javalearning.employeemanagemnetsystem.shared.data.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {
    boolean existsByDivisionId(Long id);
}
