package com.javalearning.employeemanagemnetsystem.feedback.dto;

import com.javalearning.employeemanagemnetsystem.user.dto.UserResponse;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFeedbackRequest {
    private String message;
    private Long fromUserId;
    private Long toUserId;
}
