package com.mck.study5.learning_service.controllers;



import com.mck.study5.learning_service.constants.MessageKeys;
import com.mck.study5.learning_service.dto.request.exam.ExamCategoryDTO;
import com.mck.study5.learning_service.dto.response.ApiResponse;
import com.mck.study5.learning_service.services.exams.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/learning/exam_category")
@RequiredArgsConstructor
public class ExamCategoryController {
    private final IExamService examService;

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> searchExamCategory(@RequestParam String keyword){
        return ResponseEntity.ok(ApiResponse.success(examService.getExamCategories(), 200, null));
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> createOrUpdate(@RequestBody ExamCategoryDTO dto){
        return ResponseEntity.ok(ApiResponse.success(examService.createOrUpdateExamCategory(dto),200, MessageKeys.SUCCESS));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(examService.deleteById(id),200,MessageKeys.DELETE_SUCCESSFULLY));
    }


}
