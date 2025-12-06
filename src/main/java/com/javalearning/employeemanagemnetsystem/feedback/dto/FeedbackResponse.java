package com.javalearning.employeemanagemnetsystem.feedback.dto;

import com.javalearning.employeemanagemnetsystem.user.dto.UserResponse;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackResponse {
    private Long id;
    private String message;
    private UserResponse fromUserDetails;
    private UserResponse toUserDetails;
}
