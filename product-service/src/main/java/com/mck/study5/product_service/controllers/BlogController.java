package com.mck.study5.product_service.controllers;

import com.mck.study5.product_service.services.blogs.BlogService;
import dtos.response.blogs.BlogListResponse;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import response.ApiResponse;

@RestController
@RequestMapping("${api.prefix}/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<BlogListResponse>> findAllByKeyword(
            @RequestParam String keyword,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        BlogListResponse blogListResponse = blogService.getBlogsByKeyword(keyword, page, size);
        return ResponseEntity.ok(ApiResponse.success(blogListResponse, HttpStatus.OK.value(),""));
    }


}
