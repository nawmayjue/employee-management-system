package com.javalearning.employeemanagemnetsystem.shared.data.model;

import com.javalearning.employeemanagemnetsystem.user.dto.UserResponse;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="feedback")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    private User fromUser;

    @ManyToOne
    private User toUser;
}
