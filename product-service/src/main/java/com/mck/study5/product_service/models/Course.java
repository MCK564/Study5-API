package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mck.study5.product_service.responses.courses.CourseResponse;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="courses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Course extends BaseEntity{
    private String name;
    private String description;
    private Double initialPrice;
    private Double finalPrice;
    private Long thumbnailId;
    private String thumbnailUrl;
    private String teacherDescription;
    private String introductionVideo;
    private Integer assignment;
    private Integer registeredStudent;
    private String expireTime;
    private Integer studyTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="subject_id")
    @JsonManagedReference
    private Subject subject;

    @OneToMany(mappedBy = "course" ,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Lesson> lessons = new ArrayList<>();

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    public List<CourseEnrollment> courseEnrollments = new ArrayList<>();

    public static CourseResponse toResponse(Course course){
        return CourseResponse.builder()
                .id(course.getId())
                .courseName(course.getName())
                .courseDescription(course.getDescription())
                .initialPrice(course.getInitialPrice())
                .finalPrice(course.getFinalPrice())
                .thumbnail(course.getThumbnailUrl())
                .teacherDescription(course.getTeacherDescription())
                .introductionVideo(course.getIntroductionVideo())
                .assignment(course.getAssignment())
                .registeredStudent(course.getRegisteredStudent())
                .expireTime(course.getExpireTime())
                .studyTime(course.getStudyTime())
                .subjectName(course.getSubject().getName())
                .build();
    }
}
