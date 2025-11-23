package com.mck.study5.product_service.responses.lessons;


import com.mck.study5.product_service.models.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonResponse {
    private Long id;
    private String title;
    private String description;

    public static LessonResponse fromLesson(Lesson lesson) {
        return LessonResponse.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .description(lesson.getDescription())
                .build();
    }
}
