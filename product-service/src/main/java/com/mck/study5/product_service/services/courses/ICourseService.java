package com.mck.study5.product_service.services.courses;

import com.mck.study5.product_service.dtos.request.course.CourseDTO;
import com.mck.study5.product_service.responses.courses.CourseDetailResponse;
import com.mck.study5.product_service.responses.courses.CourseListResponse;
import com.mck.study5.product_service.responses.courses.CourseResponse;
import com.mck.study5.product_service.responses.lessons.LessonDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface ICourseService {
    CourseResponse getCourseById(Long id);
    CourseResponse createOrUpdate(CourseDTO courseDTO);
    CourseResponse deleteCourseById(Long id);
    CourseListResponse getAllCourses(int page, int size);
    CourseListResponse findAllByConditions(int page, int size, String keyword);
    CourseListResponse findBySubjectID(Long id);
    CourseDetailResponse getCourseDetailById(Long id);
    CourseListResponse getUnlockCourseByUserId(Long userId);

}
