package com.mck.study5.product_service.models;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name="courses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course extends BaseEntity{
    private String courseName;
    private String courseDescription;
    private Double initialPrice;
    private Double finalPrice;
    private String thumbnail;

    private String teacherDescription;
    private String introductionVideo;
    private Integer assignment;
    private Integer registeredStudent;
    private Integer expireTime; //month


}
