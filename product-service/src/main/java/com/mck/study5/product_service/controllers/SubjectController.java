package com.mck.study5.product_service.controllers;

import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.responses.ApiResponse;
import com.mck.study5.product_service.services.subjects.ISubjectService;

import com.mck.study5.product_service.dtos.request.subject.SubjectDTO;
import com.mck.study5.product_service.responses.subject.SubjectListResponse;
import com.mck.study5.product_service.responses.subject.SubjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final ISubjectService subjectService;

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<SubjectListResponse>> getAllSubjects() {
        SubjectListResponse subjectListResponse = subjectService.getSubjects();
        return ResponseEntity.ok(ApiResponse.success(subjectListResponse,200, MessageKeys.SUCCESS));
    }

    @PostMapping()
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<SubjectResponse>> createOrUpdateSubject(@RequestBody SubjectDTO dto){
        SubjectResponse data =  subjectService.createOrUpdateSubject(dto);
        return ResponseEntity.ok(ApiResponse.success(data,200, MessageKeys.SUCCESS));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<SubjectResponse>> deleteSubject(@PathVariable("id")Long id){
        SubjectResponse data =  subjectService.deleteSubject(id);
        return ResponseEntity.ok(ApiResponse.success(data,200, MessageKeys.DELETE_SUCCESSFULLY));
    }




}
