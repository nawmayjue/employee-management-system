package com.javalearning.employeemanagemnetsystem.shared.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @Column(name="status_id")
    private Integer statusId;

    private String code;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Position position;
}
