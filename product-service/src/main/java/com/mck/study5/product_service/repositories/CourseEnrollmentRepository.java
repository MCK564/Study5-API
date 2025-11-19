package com.mck.study5.product_service.repositories;

import com.mck.study5.product_service.models.CourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseEnrollmentRepository extends JpaRepository <CourseEnrollment,Long> {
    Boolean existsByUserIdAndCourse_Id(Long userId, Long courseId);
    List<CourseEnrollment> findAllByUserId(Long userId);
    CourseEnrollment findByUserIdAndCourse_Id(Long userId, Long courseId);
}
