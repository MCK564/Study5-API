package com.mck.study5.user_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mck.study5.user_service.enums.TrainingType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "training_history")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingHistory extends BaseEntity{
    private String result;
    private String trainingAmount;
    private String linkToDetail;
    private String examName;
    private Long examId;
    private TrainingType trainingType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;




}
