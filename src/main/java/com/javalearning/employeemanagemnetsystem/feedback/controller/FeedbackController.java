package com.javalearning.employeemanagemnetsystem.feedback.controller;

import com.javalearning.employeemanagemnetsystem.feedback.dto.CreateFeedbackRequest;
import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackResponse;
import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackTemplateResponse;
import com.javalearning.employeemanagemnetsystem.feedback.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees/feedback")
@AllArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @GetMapping("/template")
    public ResponseEntity<FeedbackTemplateResponse> getFeedbackTemplate(){
        return ResponseEntity.ok().body(feedbackService.retrieveFeedbackTemplate());
    }

    @PostMapping
    public ResponseEntity<?> createFeedback(
            @RequestBody CreateFeedbackRequest createFeedbackRequest
            ){
        try {
            return ResponseEntity.ok().body(feedbackService.createFeedback(createFeedbackRequest));
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrieveFeedbackById(
            @PathVariable Long id
    ){
        try {
            return ResponseEntity.ok().body(feedbackService.retrieveById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<FeedbackResponse>> retrieveAllFeedback(){
        return ResponseEntity.ok().body(feedbackService.retrieveAll());
    }
}
