package com.mck.study5.product_service.services.courses;

import com.mck.study5.product_service.models.Course;
import com.mck.study5.product_service.repositories.CourseRepository;
import constants.MessageKeys;
import dtos.request.course.CourseDTO;
import dtos.response.courses.CourseListResponse;
import dtos.response.courses.CourseResponse;
import exceptions.DataNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CourseService implements ICourseService{
    private final CourseRepository courseRepository;

    @Override
    public CourseResponse getCourseById(Long id) {
        Course existingCourse = courseRepository.findById(id).orElseThrow(()-> new DataNotFoundException(
                "can not find course with id = "+ id
        ));

        return Course.toResponse(existingCourse);
    }

    @Override
    public CourseResponse createOrUpdate(CourseDTO courseDTO) {
        return null;
    }

    @Override
    public CourseResponse deleteCourseById(Long id) {
        return null;
    }

    @Override
    public CourseListResponse getAllCourses(int page, int size) {
        return null;
    }

    @Override
    public CourseListResponse findAllByConditions(int page, int size, List<String> conditions) {
        return null;
    }
}
