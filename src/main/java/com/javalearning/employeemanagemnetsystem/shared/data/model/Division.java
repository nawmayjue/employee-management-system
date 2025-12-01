package com.javalearning.employeemanagemnetsystem.shared.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "division")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name="status_id")
    private Integer statusId;

    private String code;
}
