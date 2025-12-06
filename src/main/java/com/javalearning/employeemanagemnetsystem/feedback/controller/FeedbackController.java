package com.javalearning.employeemanagemnetsystem.feedback.controller;

import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackTemplateResponse;
import com.javalearning.employeemanagemnetsystem.feedback.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees/feedback")
@AllArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @GetMapping("/template")
    public ResponseEntity<FeedbackTemplateResponse> getFeedbackTemplate(){
        return ResponseEntity.ok().body(feedbackService.retrieveFeedbackTemplate());
    }
}
