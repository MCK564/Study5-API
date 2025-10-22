package com.mck.study5.product_service.controllers;

import com.mck.study5.product_service.services.blogs.BlogService;
import constants.MessageKeys;
import com.mck.study5.product_service.dtos.request.blog.BlogDTO;
import dtos.response.blogs.BlogListResponse;
import dtos.response.blogs.BlogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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


    @PostMapping("")
    public ResponseEntity<ApiResponse<BlogResponse>> createOrUpdateBlog(
            @RequestBody BlogDTO dto){
        ApiResponse<BlogResponse> response = new ApiResponse<>();
        if(dto == null){
            return ResponseEntity.ok(ApiResponse.failure(null,400, MessageKeys.NULL_REQUEST_DTO));
        }
        BlogResponse result = blogService.createOrUpdate(dto);
        return ResponseEntity.ok(ApiResponse.success(result,HttpStatus.OK.value(),""));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BlogResponse>> findById(@PathVariable("id") Long id){
        BlogResponse blog = blogService.getBlog(id);
        return ResponseEntity.ok(ApiResponse.success(blog,HttpStatus.OK.value(),MessageKeys.SUCCESS));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<BlogResponse>> deleteById(@PathVariable("id") Long id){
        BlogResponse blog = blogService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(blog,HttpStatus.OK.value(),MessageKeys.DELETE_SUCCESSFULLY));
    }


}
