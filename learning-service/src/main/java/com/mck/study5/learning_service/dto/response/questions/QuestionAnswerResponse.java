package com.mck.study5.learning_service.dto.response.questions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.learning_service.models.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionAnswerResponse {
    private Long id;

    private Boolean correct;

    @JsonProperty("chosen_answer")
    private String chosenAnswer;

    @JsonProperty("correct_answer")
    private String correctAnswer;


    private String script;
    private String question;

    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("image_id")
    private Long imageId;

    private String audio;
    @JsonProperty("audio_id")
    private Long audioId;
    private String transcript;

    @JsonProperty("answer_a")
    private String answerA;

    @JsonProperty("answer_b")
    private String answerB;

    @JsonProperty("answer_c")
    private String answerC;

    @JsonProperty("answer_d")
    private String answerD;

    @JsonProperty("detailed_explanation")
    private String detailedExplanation;

    private String status;

    private String category;

    @JsonProperty("difficulty_level")
    private String difficultyLevel;

    private String type;

    public static QuestionAnswerResponse from(Question question, String chosenAnswer ) {
        return QuestionAnswerResponse.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .answerA(question.getAnswerA())
                .answerB(question.getAnswerB())
                .answerC(question.getAnswerC())
                .answerD(question.getAnswerD())
                .chosenAnswer(chosenAnswer)
                .correctAnswer(question.getCorrectAnswer())
                .status(question.getStatus())
                .category(question.getCategory())
                .difficultyLevel(question.getDifficultyLevel())
                .type(question.getType())
                .script(question.getScript())
                .audio(question.getAudio())
                .audioId(question.getAudioId())
                .transcript(question.getTranscript())
                .detailedExplanation(question.getDetailedExplanation())
                .imageId(question.getImageId())
                .imageUrl(question.getImageUrl())
                .build();
    }
}

