package com.javalearning.employeemanagemnetsystem.user.repository.jpa;

import com.javalearning.employeemanagemnetsystem.shared.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
}
