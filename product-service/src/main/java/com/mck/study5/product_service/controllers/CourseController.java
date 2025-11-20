package com.mck.study5.product_service.controllers;

import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.dtos.request.course.CourseDTO;
import com.mck.study5.product_service.responses.ApiResponse;
import com.mck.study5.product_service.services.courses.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/courses")
@RequiredArgsConstructor
public class CourseController {
    private final ICourseService courseService;

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> getCourses(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer size,
            @RequestParam String keyword
    ) {
        return ResponseEntity.ok(ApiResponse.success(courseService.findAllByConditions(page, size, keyword), 200, MessageKeys.SUCCESS));
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> getCourseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ApiResponse.success(courseService.getCourseDetailById(id), 200, MessageKeys.SUCCESS));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> deleteCourseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ApiResponse.success(courseService.deleteCourseById(id), 200, MessageKeys.DELETE_SUCCESSFULLY));
    }


    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> createOrUpdateCourse(@RequestBody CourseDTO dto) {
        return ResponseEntity.ok(ApiResponse.success(courseService.createOrUpdate(dto), 200, MessageKeys.SUCCESS));
    }


    @GetMapping("/unlock")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> getOwnUnlockedCourses(
            @RequestHeader(value="X-User-Id", required = true)Long userId
    ){
        return ResponseEntity.ok(ApiResponse.success(courseService.getUnlockCourseByUserId(userId), 200, MessageKeys.SUCCESS));
    }

}