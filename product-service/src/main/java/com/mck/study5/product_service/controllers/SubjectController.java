package com.mck.study5.product_service.controllers;

import com.mck.study5.product_service.services.subjects.ISubjectService;
import constants.MessageKeys;
import com.mck.study5.product_service.dtos.request.subject.SubjectDTO;
import dtos.response.subject.SubjectListResponse;
import dtos.response.subject.SubjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.ApiResponse;

@RestController
@RequestMapping("${api.prefix}/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final ISubjectService subjectService;

    @GetMapping()
    public ResponseEntity<ApiResponse<SubjectListResponse>> getAllSubjects() {
        SubjectListResponse subjectListResponse = subjectService.getSubjects();
        return ResponseEntity.ok(ApiResponse.success(subjectListResponse,200, MessageKeys.SUCCESS));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<SubjectResponse>> createOrUpdateSubject(@RequestBody SubjectDTO dto){
        SubjectResponse data =  subjectService.createOrUpdateSubject(dto);
        return ResponseEntity.ok(ApiResponse.success(data,200, MessageKeys.SUCCESS));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<SubjectResponse>> deleteSubject(@PathVariable("id")Long id){
        SubjectResponse data =  subjectService.deleteSubject(id);
        return ResponseEntity.ok(ApiResponse.success(data,200, MessageKeys.DELETE_SUCCESSFULLY));
    }




}
