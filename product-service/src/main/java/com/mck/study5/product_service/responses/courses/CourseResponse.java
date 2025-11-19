package com.mck.study5.product_service.responses.courses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {
    private Long id;

    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("course_desc")
    private String courseDescription;

    @JsonProperty("initial_price")
    private Double initialPrice;

    @JsonProperty("final_price")
    private Double finalPrice;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @JsonProperty("teacher_desc")
    private String teacherDescription;

    @JsonProperty("introduction_video")
    private String introductionVideo;

    private Integer assignment;

    @JsonProperty("registered_student")
    private Integer registeredStudent;

    @JsonProperty("expire_time")
    private String expireTime; //month

    @JsonProperty("study_time")
    private Integer studyTime;

    @JsonProperty("subject_name")
    private String subjectName;
}
