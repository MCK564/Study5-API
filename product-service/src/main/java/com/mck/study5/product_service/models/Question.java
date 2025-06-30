package com.mck.study5.product_service.models;


import com.mck.study5.product_service.enums.QuestionStatus;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="questions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question extends BaseEntity{
    private String script;
    private String question;
    private String transcript;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String detailedExplanation;
    private String correctAnswer;

    @Enumerated(EnumType.STRING)
    private QuestionStatus status;

    private String category;
    private String difficultyLevel;
    private String type;

}
