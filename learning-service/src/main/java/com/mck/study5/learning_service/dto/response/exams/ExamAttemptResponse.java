package com.mck.study5.learning_service.dto.response.exams;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.learning_service.models.Exam;
import com.mck.study5.learning_service.models.ExamAttempt;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamAttemptResponse {
    private Long id;
    private Boolean completed;
    private String status;
    private LocalDateTime startAt;
    private Long userId;
    private Double score;
    private LocalDateTime endAt;
    private Integer totalCorrect;
    private Integer durationSec;



    @JsonProperty("exam_id")
    private Long examId;

    public static ExamAttemptResponse from(ExamAttempt att) {
            return ExamAttemptResponse.builder()
                    .id(att.getId())
                    .completed(att.getCompleted())
                    .status(att.getStatus())
                    .startAt(att.getStartAt())
                    .userId(att.getUserId())
                    .score(att.getScore())
                    .endAt(att.getEndAt())
                    .totalCorrect(att.getTotalCorrect())
                    .durationSec(att.getDurationSec())
                    .examId(att.getExam().getId())
                    .build();
    }
}
