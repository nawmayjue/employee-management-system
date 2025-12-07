package com.javalearning.employeemanagemnetsystem.mail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    @Async
    @Override
    public void sendFeedbackMail(String fromEmail, String toEmail, String messageBody) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Feedback from " + fromEmail);
            message.setText(messageBody);
            mailSender.send(message);
            log.info("Sent message to {}", toEmail);
        } catch (Exception e) {
            log.info("Failed to send feedback mail to {}", toEmail, e);
        }
    }
}
