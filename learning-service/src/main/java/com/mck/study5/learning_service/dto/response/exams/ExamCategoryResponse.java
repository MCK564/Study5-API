package com.mck.study5.learning_service.dto.response.exams;


import com.mck.study5.learning_service.models.ExamCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamCategoryResponse {
    private Long id;
    private String content;


    public static ExamCategoryResponse from(ExamCategory examCategory) {
        return ExamCategoryResponse.builder()
                .id(examCategory.getId())
                .content(examCategory.getContent())
                .build();
    }
}
