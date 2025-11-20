package com.mck.study5.learning_service.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="exam_attempts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ExamAttempt extends BaseEntity{
    private Long userId;
    private Double score= 0.0;
    private Boolean completed=false;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Integer totalCorrect=0;
    private Integer durationSec;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    private Exam exam;


}
