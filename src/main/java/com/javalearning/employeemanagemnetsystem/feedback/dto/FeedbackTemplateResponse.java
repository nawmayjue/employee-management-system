package com.javalearning.employeemanagemnetsystem.feedback.dto;

import com.javalearning.employeemanagemnetsystem.user.dto.UserResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackTemplateResponse {
    private List<UserResponse> fromUserOptions;
    private List<UserResponse> toUserOptions;
}
