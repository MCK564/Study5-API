package com.mck.study5.product_service.services.lesson;

import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.converter.Converter;
import com.mck.study5.product_service.dtos.request.lesson.LessonDTO;
import com.mck.study5.product_service.exceptions.PermissionDenyException;
import com.mck.study5.product_service.models.CourseEnrollment;
import com.mck.study5.product_service.models.Lesson;
import com.mck.study5.product_service.models.Progress;
import com.mck.study5.product_service.repositories.CourseEnrollmentRepository;
import com.mck.study5.product_service.repositories.CourseRepository;
import com.mck.study5.product_service.repositories.LessonRepository;
import com.mck.study5.product_service.repositories.ProgressRepository;
import com.mck.study5.product_service.responses.lessons.LessonDetailResponse;
import com.mck.study5.product_service.responses.lessons.LessonResponse;
import com.mck.study5.product_service.responses.lessons.ListLessonDetailResponse;
import com.mck.study5.product_service.responses.lessons.ListLessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService implements ILessonService {
    private final LessonRepository lessonRepository;
    private final CourseEnrollmentRepository courseEnrollmentRepository;
    private final ProgressRepository progressRepository;
    private final Converter converter;
    private final CourseRepository courseRepository;

    @Override
    public LessonDetailResponse getLessonDetailById(Long id, Long userId,Long courseId) {
        if(courseEnrollmentRepository.existsByUserIdAndCourse_Id(userId, courseId)){
            return LessonDetailResponse.fromLesson(lessonRepository.findById(id).get());
        }
        else{
           throw new PermissionDenyException(MessageKeys.COURSE_INVALID);
        }
    }

    @Override
    public ListLessonDetailResponse getListLessonByCourseId(Long courseId, Long userId) {
        if(courseEnrollmentRepository.existsByUserIdAndCourse_Id(userId, courseId)){
            List<LessonDetailResponse> responses = lessonRepository
                    .findAllByCourse_Id(courseId)
                    .stream()
                    .map(LessonDetailResponse::fromLesson)
                    .toList();
            return ListLessonDetailResponse.builder()
                    .responses(responses)
                    .quantity(responses.size())
                    .build();
        }
        else{
            throw new PermissionDenyException(MessageKeys.COURSE_INVALID);
        }
    }

    @Override
    public LessonResponse deleteLessonById(Long id) {
        if(lessonRepository.existsById(id)){
            LessonResponse response = LessonResponse.fromLesson(lessonRepository.findById(id).get());
            lessonRepository.deleteById(id);

//          publish kafka message delete video by lesson.videoId()
            return response;

        }
        return null;
    }

    @Override
    public LessonDetailResponse createOrUpdateLesson(LessonDTO dto) {
        Lesson newLesson = converter.fromLessonDTO(dto);
        newLesson.setCourse(courseRepository.findById(dto.getCourseId()).get());
        Lesson savedLesson = lessonRepository.save(newLesson);
        return LessonDetailResponse.fromLesson(savedLesson);
    }

    @Override
    public void updateProgress(Long lessonId, Long userId) {
        if(lessonRepository.existsById(lessonId)){
            Lesson existedLesson = lessonRepository.findById(lessonId).get();
            Progress progress = Progress.builder()
                    .userId(userId)
                    .lesson(existedLesson)
                    .build();
            progressRepository.save(progress);

            CourseEnrollment existedCourseEnrollment = courseEnrollmentRepository.findByUserIdAndCourse_Id(userId, existedLesson.getCourse().getId());
            existedCourseEnrollment.setLessonCompleted(existedCourseEnrollment.getLessonCompleted()+1);
            existedCourseEnrollment.setProgress(
                    (double)(existedCourseEnrollment.getLessonCompleted())/
                    (double)existedLesson.getCourse().getLessons().size());
            courseEnrollmentRepository.save(existedCourseEnrollment);
        }
    }

    @Override
    public ListLessonResponse getAllLessonsByCourseId(Long courseId) {
            List<LessonResponse> response = lessonRepository.findAllByCourse_Id(courseId)
                    .stream()
                    .map(LessonResponse::fromLesson)
                    .toList();
            return ListLessonResponse.builder()
                    .responses(response)
                    .quantity(response.size())
                    .build();
    }

    @Override
    public void updateLessonVideo(Long courseId, String videoUrl, Long videoId) {
        Lesson existedLesson = lessonRepository.findById(courseId).get();
        existedLesson.setVideo(videoUrl);
        existedLesson.setVideoId(videoId);
        lessonRepository.save(existedLesson);
    }


}
