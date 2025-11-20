package com.mck.study5.learning_service.dto.request.exam;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ExamDTO {
    private Long id;
    private String type;
    private String title;
    private String info;
    private Integer time;
    private Integer part;

    @JsonProperty("exam_category_id")
    private Long examCategoryId;

    @JsonProperty("number_of_question")
    private Integer numberOfQuestion;
}
