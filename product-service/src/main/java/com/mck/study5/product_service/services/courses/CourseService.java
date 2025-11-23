package com.mck.study5.product_service.services.courses;

import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.converter.Converter;
import com.mck.study5.product_service.exceptions.DataNotFoundException;
import com.mck.study5.product_service.models.Course;
import com.mck.study5.product_service.models.CourseEnrollment;
import com.mck.study5.product_service.models.Subject;
import com.mck.study5.product_service.repositories.CourseEnrollmentRepository;
import com.mck.study5.product_service.repositories.CourseRepository;
import com.mck.study5.product_service.dtos.request.course.CourseDTO;
import com.mck.study5.product_service.repositories.SubjectRepository;
import com.mck.study5.product_service.responses.courses.CourseDetailResponse;
import com.mck.study5.product_service.responses.courses.CourseListResponse;
import com.mck.study5.product_service.responses.courses.CourseResponse;
import com.mck.study5.product_service.responses.lessons.LessonDetailResponse;
import com.mck.study5.product_service.responses.lessons.LessonDetailResponse;
import com.mck.study5.product_service.responses.lessons.LessonResponse;
import com.mck.study5.product_service.responses.lessons.ListLessonResponse;
import com.mck.study5.product_service.responses.subject.SubjectResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService{
    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    private final CourseEnrollmentRepository courseEnrollmentRepository;
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
        Course course = converter.fromCourseDTO(courseDTO);
        Subject existedSubject = subjectRepository.findById(courseDTO.getSubjectId()).orElseThrow(()->
                new DataNotFoundException(MessageKeys.SUBJECT_NOT_FOUND+": no subject with id = "+courseDTO.getSubjectId()));

        course.setSubject(existedSubject);
        return Course.toResponse(courseRepository.save(course));
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
    public CourseListResponse findAllByConditions(int page, int size, String keyword) {
        PageRequest pageRequest = PageRequest.of(page-1,size);
        Page<Course> pages = courseRepository.findAll(keyword, pageRequest);

        List<CourseResponse> responses = pages.getContent()
                .stream()
                .map(Course::toResponse)
                .toList();

        return CourseListResponse.builder()
                .courses(responses)
                .currentPage(page)
                .pageSize(size)
                .totalPages(pages.getTotalPages())
                .build();
    }


    @Override
    public CourseListResponse findBySubjectID(Long id) {
        List<CourseResponse> list = courseRepository.findAllBySubject_id(id)
                .stream().map(Course::toResponse).toList();
        return CourseListResponse.builder()
                .courses(list)
                .build();
    }

    @Override
    public CourseDetailResponse getCourseDetailById(Long id) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(MessageKeys.DATA_NOT_FOUND));
        List<LessonResponse> lessons = existingCourse.getLessons().stream().map(LessonResponse::fromLesson).toList();
        ListLessonResponse listLessons = ListLessonResponse.builder()
                .responses(lessons)
                .quantity(lessons.size())
                .build();
        return  CourseDetailResponse.builder()
                .subject(Subject.toResponse(existingCourse.getSubject()))
                .course(Course.toResponse(existingCourse))
                .lessons(listLessons)
                .build();
    }

    @Override
    public CourseListResponse getUnlockCourseByUserId(Long userId) {
       List<CourseResponse> courses =  courseEnrollmentRepository
               .findAllByUserId(userId).stream()
               .map(CourseEnrollment::getCourse)
               .map(Course::toResponse)
               .toList();

       return CourseListResponse.builder()
               .courses(courses)
               .build();
    }

}
