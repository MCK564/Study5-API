package com.mck.study5.user_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mck.study5.user_service.enums.TrainingType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "training_history")
public class TrainingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private String result;
    private String trainingAmount;

    private String linkToDetail;
    private String examName;

    private TrainingType trainingType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;
}
