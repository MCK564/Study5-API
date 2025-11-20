package com.mck.study5.learning_service.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="exam_results")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ExamResult extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_attempt_id")
    private ExamAttempt examAttempt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    private String chosenAnswer;
}
