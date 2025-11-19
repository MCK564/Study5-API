package com.mck.study5.learning_service.dto.request.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class QuestionDTO {
    private Long id;
    private String script;
    private String question;
    private String transcript;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

    @JsonProperty("detailed_explanation")
    private String detailedExplanation;

    @JsonProperty("correct_answer")
    private String correctAnswer;

    private String status;

    private String category;

    @JsonProperty("difficulty_level")
    private String difficultyLevel; //easy-medium-hard
    private String type;

    @JsonProperty("exam_id")
    private Long examId;
}
