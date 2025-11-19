package com.mck.study5.product_service.controllers;

import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.responses.ApiResponse;
import com.mck.study5.product_service.services.blogs.BlogService;

import com.mck.study5.product_service.dtos.request.blog.BlogCategoryDTO;
import com.mck.study5.product_service.responses.blogs.BlogCategoryListResponse;
import com.mck.study5.product_service.responses.blogs.BlogCategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products/blogCategory")
@RequiredArgsConstructor
public class BlogCategoryController {
    private final BlogService blogService;


    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<BlogCategoryListResponse>> getAllCategories(){
        BlogCategoryListResponse blogCategoryListResponse = blogService.getBlogCategories();
        return ResponseEntity.ok(ApiResponse.success(blogCategoryListResponse, 200, MessageKeys.SUCCESS));
    }

    @PostMapping()
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<BlogCategoryResponse>> createOrUpdate(@RequestBody BlogCategoryDTO dto){
        BlogCategoryResponse category =  blogService.createOrUpdateCategory(dto);
        return ResponseEntity.ok(ApiResponse.success(category, 200, MessageKeys.SUCCESS));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<BlogCategoryResponse>> deleteCategory(@PathVariable("id") Long id){
        BlogCategoryResponse category =  blogService.deleteCategory(id);
        return ResponseEntity.ok(ApiResponse.success(category, 200, MessageKeys.SUCCESS));
    }

}
