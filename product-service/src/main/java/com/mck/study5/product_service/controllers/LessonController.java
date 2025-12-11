package com.mck.study5.product_service.controllers;

import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.dtos.request.lesson.LessonDTO;
import com.mck.study5.product_service.models.Lesson;
import com.mck.study5.product_service.responses.ApiResponse;
import com.mck.study5.product_service.services.lesson.ILessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final ILessonService lessonService;

    @GetMapping("/unlock")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> getListLessonDetailByCourseId(
            @RequestHeader(value = "X-User-Id", required = true)Long userId,
            @RequestParam(value="courseId", required = true) Long courseId
    ){
        return ResponseEntity.ok(ApiResponse.success(lessonService
                .getListLessonByCourseId(courseId,userId),200, MessageKeys.SUCCESS));
    }

   @PostMapping("")
   @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> createOrUpdateLesson(
           @RequestBody LessonDTO dto){
        return ResponseEntity.ok(ApiResponse.success(lessonService.createOrUpdateLesson(dto),
                200, MessageKeys.SUCCESS));
   }

   @DeleteMapping("/{id}")
   @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> deleteLessonById(@PathVariable("id") Long id){
       return ResponseEntity.ok(ApiResponse.success(lessonService.deleteLessonById(id),
               200, MessageKeys.DELETE_SUCCESSFULLY));
    }


    @PostMapping("/update-progress/{id}")
    @PreAuthorize(("hasAnyRole('ADMIN','USER')"))
    public ResponseEntity<ApiResponse<?>> updateLessonProgress(
          @RequestHeader(value="X-User-Id", required = true)Long userId,
          @PathVariable(value="id")  Long lessonId
    ){
        lessonService.updateProgress(lessonId,userId);
        return ResponseEntity.ok(ApiResponse.success(null,200,MessageKeys.SUCCESS));
    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> getListLessonByCourseId(
            @RequestHeader(value = "X-User-Id", required = true)Long userId,
            @RequestParam(value="courseId", required = true) Long courseId
    ){
        return ResponseEntity.ok(ApiResponse.success(lessonService
                .getAllLessonsByCourseId(courseId),200, MessageKeys.SUCCESS));
    }
}
