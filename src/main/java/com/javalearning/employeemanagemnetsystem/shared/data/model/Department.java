package com.javalearning.employeemanagemnetsystem.shared.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "department")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name="status_id")
    private Integer statusId;

    private String code;

    @ManyToOne
    private Division division;
}
