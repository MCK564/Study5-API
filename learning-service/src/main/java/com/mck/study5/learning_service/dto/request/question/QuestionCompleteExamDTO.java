package com.mck.study5.learning_service.dto.request.question;


import lombok.Data;

@Data
public class QuestionCompleteExamDTO {
    private Long questionId;
    private String answer;
}
