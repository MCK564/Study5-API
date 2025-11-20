package com.mck.study5.learning_service.controllers;

import com.mck.study5.learning_service.dto.request.exam.ExamDTO;
import com.mck.study5.learning_service.dto.response.ApiResponse;
import com.mck.study5.learning_service.services.exams.IExamService;
import com.mck.study5.learning_service.services.questions.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/exams")
@RequiredArgsConstructor
public class ExamController {
    private final IExamService examService;
    private final IQuestionService questionService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<?>> searchExam(
            @RequestParam(value="page", defaultValue = "1") Integer page,
            @RequestParam(value="limit", defaultValue = "20") Integer limit,
            @RequestParam(value="keyword", required = false) String keyword,
            @RequestParam(value="category_id", required = false) Long categoryId

    ){
      return ResponseEntity.ok(ApiResponse.success(examService.findByCondition(page,limit,categoryId,keyword),200,null));
    }

    @GetMapping("/admin/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> adminGetExam(@RequestParam(value="id") Long id){
            return null;
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> getExam(@RequestParam(value="id") Long id){
       return ResponseEntity.ok(ApiResponse.success(examService.findById(id),200,null));
    }


    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> createOrUpdateExam(
            @RequestBody ExamDTO dto
            ){
       return ResponseEntity.ok(ApiResponse.success(examService.createOrUpdate(dto),200,null));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> deleteExam(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(examService.delete(id),200,null));
    }

}
