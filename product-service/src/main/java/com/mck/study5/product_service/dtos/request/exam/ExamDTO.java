package com.mck.study5.product_service.dtos.request.exam;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO {
    private Long id;
    private String type;
    private String title;
    private String info;
    private Integer time;
    private Integer part;

    @JsonProperty("exam_category_id")
    private Long examCategoryId;

    @JsonProperty("total_score")
    private Integer totalScore;

    private Boolean completed;

    @JsonProperty("number_of_completion")
    private Integer numberOfCompletion;

    @JsonProperty("number_of_question")
    private Integer numberOfQuestion;
}
