package com.mck.study5.product_service.dtos.request.lesson;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.product_service.models.Course;
import com.mck.study5.product_service.models.Progress;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LessonDTO {
    private Long id;
    private String title;
    private String description;
    private String transcript;
    @JsonProperty("course_id")
    private Long courseId;
}
