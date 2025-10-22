package com.mck.study5.product_service.services.courses;

import com.mck.study5.product_service.converter.Converter;
import com.mck.study5.product_service.models.Course;
import com.mck.study5.product_service.repositories.CourseRepository;
import constants.MessageKeys;
import com.mck.study5.product_service.dtos.request.course.CourseDTO;
import dtos.response.courses.CourseListResponse;
import dtos.response.courses.CourseResponse;
import exceptions.DataNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CourseService implements ICourseService{
    private final CourseRepository courseRepository;
    private final Converter converter;

    @Override
    public CourseResponse getCourseById(Long id) {
        Course existingCourse = courseRepository.findById(id).orElseThrow(()-> new DataNotFoundException(
                "can not find course with id = "+ id
        ));

        return Course.toResponse(existingCourse);
    }

    @Override
    public CourseResponse createOrUpdate(CourseDTO courseDTO) {
        Course course ;
        if(courseDTO.getId()!=null){
            course = courseRepository.findById(courseDTO.getId())
                    .orElseThrow(()-> new DataNotFoundException(MessageKeys.DATA_NOT_FOUND));

        }
        course = converter.fromCourseDTO(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return Course.toResponse(savedCourse);
    }

    @Override
    public CourseResponse deleteCourseById(Long id) {
        Course existingCourse  = courseRepository
                .findById(id)
                .orElseThrow(()-> new DataNotFoundException(MessageKeys.DATA_NOT_FOUND));
        courseRepository.delete(existingCourse);
        return Course.toResponse(existingCourse);
    }

    @Override
    public CourseListResponse getAllCourses(int page, int size) {
        List<CourseResponse> courses = courseRepository.findAll()
                .stream().map(Course::toResponse).toList();
        return CourseListResponse.builder()
                .courses(courses)
                .build();
    }

    @Override
    public CourseListResponse findAllByConditions(int page, int size, List<String> conditions) {
        return null;
    }

    @Override
    public CourseListResponse findBySubjectID(Long id) {
        List<CourseResponse> list = courseRepository.findAllBySubject_id(id)
                .stream().map(Course::toResponse).toList();
        return CourseListResponse.builder()
                .courses(list)
                .build();
    }
}
