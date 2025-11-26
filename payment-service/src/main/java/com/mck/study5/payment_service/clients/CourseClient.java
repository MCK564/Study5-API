package com.mck.study5.payment_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "product-service",
        path = "/products/courses"
)
public interface CourseClient {
    @GetMapping("/check")
    Boolean checkCourseUnlock(
            @RequestParam("courseId") Long courseId,
            @RequestParam("userId") Long userId
    );
}
