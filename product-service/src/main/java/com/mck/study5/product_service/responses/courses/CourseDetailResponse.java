package com.mck.study5.product_service.responses.courses;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.product_service.responses.lessons.ListLessonResponse;
import com.mck.study5.product_service.responses.subject.SubjectResponse;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDetailResponse {
    private CourseResponse course;
    private SubjectResponse subject;
    private ListLessonResponse lessons;
}
