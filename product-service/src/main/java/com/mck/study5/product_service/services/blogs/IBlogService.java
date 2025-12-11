package com.mck.study5.product_service.services.blogs;

import com.mck.study5.product_service.dtos.request.blog.BlogCategoryDTO;
import com.mck.study5.product_service.dtos.request.blog.BlogDTO;
import com.mck.study5.product_service.responses.blogs.BlogCategoryListResponse;
import com.mck.study5.product_service.responses.blogs.BlogCategoryResponse;
import com.mck.study5.product_service.responses.blogs.BlogListResponse;
import com.mck.study5.product_service.responses.blogs.BlogResponse;
import org.springframework.stereotype.Service;


public interface IBlogService {
    BlogListResponse getBlogs(int page, int size);
    BlogResponse getBlog(Long id);
    BlogResponse createOrUpdate(BlogDTO blogDTO);
    BlogResponse delete(Long id);
    BlogListResponse getBlogsByKeyword(String keyword, int page, int size);
    BlogCategoryListResponse getBlogCategories();
    BlogCategoryResponse createOrUpdateCategory(BlogCategoryDTO blogCategoryDTO);
    BlogCategoryResponse deleteCategory(Long id);
    void updateBlogImage(Long blogId, String imageUrl, Long imageId);
    void evictBlogCache(Long id);
}
