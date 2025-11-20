package com.mck.study5.learning_service.dto.response.questions;


import com.mck.study5.learning_service.models.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionResponse {
    private Long id;
    private String script;
    private String question;
    private String imageUrl;
    private Long imageId;
    private Long audioId;
    private String audio;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

    public static QuestionResponse from (Question question) {
        return QuestionResponse.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .answerA(question.getAnswerA())
                .answerB(question.getAnswerB())
                .answerC(question.getAnswerC())
                .answerD(question.getAnswerD())
                .script(question.getScript())
                .audio(question.getAudio())
                .audioId(question.getAudioId())
                .imageId(question.getImageId())
                .imageUrl(question.getImageUrl())
                .build();

    }
}
