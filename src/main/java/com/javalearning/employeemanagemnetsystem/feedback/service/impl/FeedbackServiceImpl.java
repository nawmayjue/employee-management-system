package com.javalearning.employeemanagemnetsystem.feedback.service.impl;

import com.javalearning.employeemanagemnetsystem.feedback.dto.CreateFeedbackRequest;
import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackResponse;
import com.javalearning.employeemanagemnetsystem.feedback.dto.FeedbackTemplateResponse;
import com.javalearning.employeemanagemnetsystem.feedback.repository.jdbc.FeedbackJdbcRepository;
import com.javalearning.employeemanagemnetsystem.feedback.repository.jpa.FeedbackJpaRepository;
import com.javalearning.employeemanagemnetsystem.feedback.service.FeedbackService;
import com.javalearning.employeemanagemnetsystem.mail.MailService;
import com.javalearning.employeemanagemnetsystem.shared.data.model.Feedback;
import com.javalearning.employeemanagemnetsystem.shared.data.model.User;
import com.javalearning.employeemanagemnetsystem.user.repository.jdbc.UserJdbcRepository;
import com.javalearning.employeemanagemnetsystem.user.repository.jpa.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final UserJdbcRepository userJdbcRepository;
    private final FeedbackJdbcRepository feedbackJdbcRepository;
    private final FeedbackJpaRepository feedbackJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final MailService mailService;

    @Override
    public FeedbackTemplateResponse retrieveFeedbackTemplate() {
        return FeedbackTemplateResponse.builder()
                .fromUserOptions(userJdbcRepository.findALlUsers())
                .toUserOptions(userJdbcRepository.findALlUsers())
                .build();
    }

    @Override
    public List<FeedbackResponse> retrieveAll() {
        return feedbackJdbcRepository.findAll();
    }

    @Override
    public FeedbackResponse retrieveById(Long id) {
        if (!feedbackJpaRepository.existsById(id)){
            throw new RuntimeException("Feedback with id " + id + " doesn't exist");
        }
        return feedbackJdbcRepository.findById(id);
    }

    @Override
    public FeedbackResponse createFeedback(CreateFeedbackRequest createFeedbackRequest) {
        if(createFeedbackRequest.getFromUserId().equals(createFeedbackRequest.getToUserId())){
            throw new RuntimeException("You can't sent message to yourself");
        }

         if(!userJpaRepository.existsById(createFeedbackRequest.getFromUserId())){
             throw new RuntimeException("From User id" + createFeedbackRequest.getFromUserId() + " doesn't exist");
         }
        if(!userJpaRepository.existsById(createFeedbackRequest.getToUserId())){
            throw new RuntimeException("To User id" + createFeedbackRequest.getToUserId() + " doesn't exist");
        }

        User fromUser = userJpaRepository.findById(createFeedbackRequest.getFromUserId())
                .orElseThrow(()-> new RuntimeException("From User id" + createFeedbackRequest.getFromUserId() + " doesn't exist"));

        User toUser = userJpaRepository.findById(createFeedbackRequest.getToUserId())
                .orElseThrow(()-> new RuntimeException("To User id" + createFeedbackRequest.getToUserId() + " doesn't exist"));



        Feedback feedback = Feedback.builder()
                .message(createFeedbackRequest.getMessage())
                .fromUser(fromUser)
                .toUser(toUser)
                .build();

        Feedback savedFeedback = feedbackJpaRepository.save(feedback);

        mailService.sendFeedbackMail(fromUser.getEmail(), toUser.getEmail(), savedFeedback.getMessage());

        return FeedbackResponse.builder()
                .id(savedFeedback.getId())
                .message(savedFeedback.getMessage())
                .fromUserDetails(
                        userJdbcRepository.findUserById(savedFeedback.getFromUser().getId())
                )
                .toUserDetails(
                        userJdbcRepository.findUserById(savedFeedback.getToUser().getId())
                )
                .build();
    }
}
