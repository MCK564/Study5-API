package com.mck.study5.product_service.controllers;

import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.responses.ApiResponse;
import com.mck.study5.product_service.services.blogs.BlogService;

import com.mck.study5.product_service.dtos.request.blog.BlogDTO;
import com.mck.study5.product_service.responses.blogs.BlogListResponse;
import com.mck.study5.product_service.responses.blogs.BlogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<BlogListResponse>> findAllByKeyword(
            @RequestParam String keyword,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        BlogListResponse blogListResponse = blogService.getBlogsByKeyword(keyword, page, size);
        return ResponseEntity.ok(ApiResponse.success(blogListResponse, HttpStatus.OK.value(),""));
    }


    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<BlogResponse>> createOrUpdateBlog(
            @RequestBody BlogDTO dto){
        if(dto == null){
            return ResponseEntity.ok(ApiResponse.failure(null,400, MessageKeys.NULL_REQUEST_DTO));
        }
        BlogResponse result = blogService.createOrUpdate(dto);
        return ResponseEntity.ok(ApiResponse.success(result,HttpStatus.OK.value(),""));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<BlogResponse>> findById(@PathVariable("id") Long id){
        BlogResponse blog = blogService.getBlog(id);
        return ResponseEntity.ok(ApiResponse.success(blog,HttpStatus.OK.value(),MessageKeys.SUCCESS));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<BlogResponse>> deleteById(@PathVariable("id") Long id){
        BlogResponse blog = blogService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(blog,HttpStatus.OK.value(),MessageKeys.DELETE_SUCCESSFULLY));
    }


}
