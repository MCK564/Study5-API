package com.mck.study5.learning_service.controllers;



import com.mck.study5.learning_service.dto.request.exam.ExamCategoryDTO;
import com.mck.study5.learning_service.dto.response.ApiResponse;
import com.mck.study5.learning_service.services.exams.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/exam_category")
@RequiredArgsConstructor
public class ExamCategoryController {
    private final IExamService examService;

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> searchExamCategory(String keyword){
        return null;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> createOrUpdate(ExamCategoryDTO dto){
        return null;
    }




}
