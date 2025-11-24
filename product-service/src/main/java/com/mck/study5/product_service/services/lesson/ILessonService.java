package com.mck.study5.product_service.services.lesson;

import com.mck.study5.product_service.dtos.request.lesson.LessonDTO;
import com.mck.study5.product_service.responses.lessons.LessonDetailResponse;
import com.mck.study5.product_service.responses.lessons.LessonResponse;
import com.mck.study5.product_service.responses.lessons.ListLessonDetailResponse;
import com.mck.study5.product_service.responses.lessons.ListLessonResponse;

public interface ILessonService {
    LessonDetailResponse getLessonDetailById(Long id, Long userId, Long courseId);
    ListLessonDetailResponse getListLessonByCourseId(Long courseId, Long userId);
    LessonResponse deleteLessonById(Long id);
    LessonDetailResponse createOrUpdateLesson(LessonDTO dto);
    void updateProgress(Long lessonId, Long userId);
    ListLessonResponse getAllLessonsByCourseId(Long courseId);
    void updateLessonVideo(Long courseId, String videoUrl, Long videoId);
}
