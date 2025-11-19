package com.mck.study5.learning_service.models;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="questions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Question extends BaseEntity{
    private String script;
    private String question;
    private String imageUrl;
    private Long imageId;
    private String audio;
    private Long audioId;
    private String transcript;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String detailedExplanation;
    private String correctAnswer;
    private String status;
    private String category;
    private String difficultyLevel;
    private String type;
}
