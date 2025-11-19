package com.mck.study5.learning_service.dto.response.exams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamAttemptResponse {
    private Long id;
    private Integer score;
    private Boolean completed;
    private String status;
}
