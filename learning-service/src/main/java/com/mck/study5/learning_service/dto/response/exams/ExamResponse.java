package com.mck.study5.learning_service.dto.response.exams;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.learning_service.models.Exam;
import com.mck.study5.learning_service.models.ExamAttempt;
import com.mck.study5.learning_service.models.ExamCategory;
import com.mck.study5.learning_service.models.Question;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamResponse {
    private Long id;
    private String type;
    private String title;
    private String info;
    private Integer time;
    private Integer part;
    private String term;
    private Long categoryId;

    @JsonProperty("number_of_completion")
    private Integer numberOfCompletion;

    @JsonProperty("number_of_question")
    private Integer numberOfQuestion;

    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    @JsonProperty("thumbnail_id")
    private Long thumbnailId;

    @JsonProperty("audio_url")
    private String audioUrl;

    @JsonProperty("audio_id")
    private Long audioId;

    public static ExamResponse from(Exam exam) {
        return ExamResponse.builder()
                .id(exam.getId())
                .type(exam.getType())
                .title(exam.getTitle())
                .info(exam.getInfo())
                .time(exam.getTime())
                .part(exam.getPart())
                .term(exam.getTerm())
                .categoryId(exam.getCategory().getId())
                .numberOfCompletion(exam.getNumberOfCompletion())
                .categoryId(exam.getCategory().getId())
                .numberOfQuestion(exam.getQuestions().size())
                .thumbnailId(exam.getThumbnailId())
                .thumbnailUrl(exam.getThumbnailUrl())
                .audioUrl(exam.getAudioUrl())
                .audioId(exam.getAudioId())
                .build();
    }
}
