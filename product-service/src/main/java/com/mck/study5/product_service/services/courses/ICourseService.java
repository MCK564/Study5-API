package com.mck.study5.product_service.services.courses;

import dtos.request.course.CourseDTO;
import dtos.response.courses.CourseListResponse;
import dtos.response.courses.CourseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICourseService {
    CourseResponse getCourseById(Long id);
    CourseResponse createOrUpdate(CourseDTO courseDTO);
    CourseResponse deleteCourseById(Long id);
    CourseListResponse getAllCourses(int page, int size);
    CourseListResponse findAllByConditions(int page, int size, List<String> conditions);

}
