package com.mck.study5.product_service.responses.lessons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.product_service.models.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonDetailResponse {
    private Long id;
    private String title;
    private String description;
    private String thumbnail;
    @JsonProperty("thumbnail_id")
    private Long thumbnailId;
    private String video;
    @JsonProperty("video_id")
    private String videoId;
    private String transcript;

    public static LessonDetailResponse fromLesson(Lesson lesson) {
        return LessonDetailResponse.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .description(lesson.getDescription())
                .thumbnail(lesson.getThumbnail())
                .thumbnailId(lesson.getThumbnailId())
                .video(lesson.getVideo())
                .videoId(lesson.getVideoId())
                .transcript(lesson.getTranscript())
                .build();
    }
}
