package com.javalearning.employeemanagemnetsystem.feedback.service.impl;

import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackTemplateResponse;
import com.javalearning.employeemanagemnetsystem.feedback.service.FeedbackService;
import com.javalearning.employeemanagemnetsystem.user.repository.jdbc.UserJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final UserJdbcRepository userJdbcRepository;

    @Override
    public FeedbackTemplateResponse retrieveFeedbackTemplate() {
        return FeedbackTemplateResponse.builder()
                .fromUserOptions(userJdbcRepository.findALlUsers())
                .toUserOptions(userJdbcRepository.findALlUsers())
                .build();
    }
}
