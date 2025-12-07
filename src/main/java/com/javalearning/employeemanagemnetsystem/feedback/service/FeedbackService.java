package com.javalearning.employeemanagemnetsystem.feedback.service;

import com.javalearning.employeemanagemnetsystem.feedback.dto.CreateFeedbackRequest;
import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackResponse;
import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackTemplateResponse;

import java.util.List;

public interface FeedbackService {
    FeedbackTemplateResponse retrieveFeedbackTemplate();
    List<FeedbackResponse> retrieveAll();
    FeedbackResponse retrieveById(Long id);
    FeedbackResponse createFeedback(CreateFeedbackRequest createFeedbackRequest);
}
