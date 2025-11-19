package com.mck.study5.product_service.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name="course_enrollments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseEnrollment extends BaseEntity
{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
    private Long userId;
    private Long paymentId;
    private Boolean completed = false;
    private Double progress = 0.0;
    private Integer LessonCompleted = 0;


    @CreatedDate
    private LocalDateTime enrollTime;
    private LocalDateTime expireAt;

    protected void onCreate() {
        enrollTime = LocalDateTime.now();
    }
}
