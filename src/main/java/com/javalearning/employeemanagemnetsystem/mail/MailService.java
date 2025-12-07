package com.javalearning.employeemanagemnetsystem.mail;

public interface MailService {
    void sendFeedbackMail(String fromEmail, String toEmail, String messageBody);
}
