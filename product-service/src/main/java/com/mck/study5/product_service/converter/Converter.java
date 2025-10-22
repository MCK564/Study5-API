package com.mck.study5.product_service.converter;

import com.mck.study5.product_service.models.Course;
import com.mck.study5.product_service.models.Subject;
import com.mck.study5.product_service.repositories.SubjectRepository;
import constants.MessageKeys;
import com.mck.study5.product_service.dtos.request.course.CourseDTO;
import exceptions.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Converter {
    private final SubjectRepository subjectRepository;

    public Course fromCourseDTO(CourseDTO dto){
        Subject subject = subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(()-> new DataNotFoundException(MessageKeys.SUBJECT_NOT_FOUND));

        return Course.builder()
                .assignment(dto.getAssignment())
                .courseDescription(dto.getCourseDescription())
                .courseName(dto.getCourseName())
                .expireTime(dto.getExpireTime())
                .finalPrice(dto.getFinalPrice())
                .initialPrice(dto.getInitialPrice())
                .introductionVideo(dto.getIntroductionVideo())
                .thumbnail(dto.getThumbnail())
                .registeredStudent(dto.getRegisteredStudent())
                .teacherDescription(dto.getTeacherDescription())
                .subject(subject)
                .build();
    }
}
