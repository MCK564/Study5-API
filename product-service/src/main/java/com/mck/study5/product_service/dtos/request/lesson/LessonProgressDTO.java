package com.mck.study5.product_service.dtos.request.lesson;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LessonProgressDTO {
    @JsonProperty("lesson_id")
    private Long lessonId;

    @JsonProperty("user_id")
    private Long userId;
}
