package com.mck.study5.product_service.services.blogs;

import dtos.request.blog.BlogDTO;
import dtos.response.blogs.BlogCategoryListResponse;
import dtos.response.blogs.BlogListResponse;
import dtos.response.blogs.BlogResponse;
import org.springframework.stereotype.Service;

@Service
public interface IBlogService {
    BlogListResponse getBlogs(int page, int size);
    BlogResponse getBlog(Long id);
    BlogResponse createOrUpdate(BlogDTO blogDTO);
    BlogResponse delete(Long id);
    BlogListResponse getBlogsByKeyword(String keyword, int page, int size);
    BlogCategoryListResponse getBlogCategories();
}
