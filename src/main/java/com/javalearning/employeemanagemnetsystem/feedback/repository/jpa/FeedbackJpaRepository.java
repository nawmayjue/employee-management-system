package com.javalearning.employeemanagemnetsystem.feedback.repository.jpa;

import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackResponse;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackJpaRepository extends JpaRepository<Feedback, Long> {
}
