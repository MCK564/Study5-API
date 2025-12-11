package com.mck.study5.learning_service.controllers;

import com.mck.study5.learning_service.constants.MessageKeys;
import com.mck.study5.learning_service.dto.request.exam.TakeExamDTO;
import com.mck.study5.learning_service.dto.request.question.QuestionCreateOrUpdateDTO;
import com.mck.study5.learning_service.dto.response.ApiResponse;
import com.mck.study5.learning_service.services.questions.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/learning/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final IQuestionService questionService;

    @GetMapping("/take-exam")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> takeExam(
            @RequestParam(value="exam_id") Long examId,
            @RequestHeader(value="X-User-Id") Long userId
    ){
       return ResponseEntity.ok(ApiResponse.success(questionService.takeExam(examId,userId),200, MessageKeys.SUCCESS));
    }


    @PostMapping("/complete-exam")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> completeExam(
            @RequestBody TakeExamDTO dto
    ){
        return ResponseEntity.ok(ApiResponse.success(questionService.completeExam(dto),200, MessageKeys.SUCCESS));
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> createOrUpdate(
            @RequestBody QuestionCreateOrUpdateDTO dto
    ){
        return ResponseEntity.ok(ApiResponse.success(questionService.createOrUpdate(dto),200, MessageKeys.SUCCESS));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> delete(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(ApiResponse.success(questionService.delete(id),200, MessageKeys.SUCCESS));
    }

}
