package com.capgemini.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "performance_review")
public class PerformanceReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String employeeCode;

    private int rating;
    private LocalDate reviewDate;

    private String comments;

    // getters & setters
}