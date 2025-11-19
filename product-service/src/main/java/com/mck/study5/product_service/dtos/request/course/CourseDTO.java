package com.mck.study5.product_service.dtos.request.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.product_service.image.ImageFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;




@Data
public class CourseDTO {
    private Long id;
    private String name;
    private String description;
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
    private String expireTime;

    @JsonProperty("subject_id")
    private Long subjectId;

    @JsonProperty("study_time")
    private Integer studyTime;
}