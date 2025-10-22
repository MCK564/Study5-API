package com.mck.study5.product_service.controllers;

import com.mck.study5.product_service.services.blogs.BlogService;
import constants.MessageKeys;
import com.mck.study5.product_service.dtos.request.blog.BlogCategoryDTO;
import dtos.response.blogs.BlogCategoryListResponse;
import dtos.response.blogs.BlogCategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.ApiResponse;

@RestController
@RequestMapping("${api.prefix}/blogCategory")
@RequiredArgsConstructor
public class BlogCategoryController {
    private final BlogService blogService;

    @GetMapping()
    public ResponseEntity<ApiResponse<BlogCategoryListResponse>> getAllCategories(){
        BlogCategoryListResponse blogCategoryListResponse = blogService.getBlogCategories();
        return ResponseEntity.ok(ApiResponse.success(blogCategoryListResponse, 200, MessageKeys.SUCCESS));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<BlogCategoryResponse>> createOrUpdate(@RequestBody BlogCategoryDTO dto){
        BlogCategoryResponse category =  blogService.createOrUpdateCategory(dto);
        return ResponseEntity.ok(ApiResponse.success(category, 200, MessageKeys.SUCCESS));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<BlogCategoryResponse>> deleteCategory(@PathVariable("id") Long id){
        BlogCategoryResponse category =  blogService.deleteCategory(id);
        return
    }

}
