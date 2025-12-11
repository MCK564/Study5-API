package com.mck.study5.learning_service.dto.request.question;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QuestionCompleteExamDTO {
    @JsonProperty("question_id")
    private Long questionId;
    private String answer;
}
