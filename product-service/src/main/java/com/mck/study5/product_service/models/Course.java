package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dtos.response.courses.CourseResponse;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="subject_id")
    @JsonManagedReference
    private Subject subject;

    public static CourseResponse toResponse(Course course){
        return CourseResponse.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseDescription(course.getCourseDescription())
                .initialPrice(course.getInitialPrice())
                .finalPrice(course.getFinalPrice())
                .thumbnail(course.getThumbnail())
                .teacherDescription(course.getTeacherDescription())
                .introductionVideo(course.getIntroductionVideo())
                .assignment(course.getAssignment())
                .registeredStudent(course.getRegisteredStudent())
                .expireTime(course.getExpireTime())
                .build();
    }

}
