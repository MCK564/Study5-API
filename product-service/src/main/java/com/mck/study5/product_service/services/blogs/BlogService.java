package com.mck.study5.product_service.services.blogs;

import com.mck.study5.product_service.models.Blog;
import com.mck.study5.product_service.models.BlogCategory;
import com.mck.study5.product_service.repositories.BlogCategoryRepository;
import com.mck.study5.product_service.repositories.BlogRepository;
import dtos.request.blog.BlogDTO;
import dtos.response.blogs.BlogCategoryListResponse;
import dtos.response.blogs.BlogCategoryResponse;
import dtos.response.blogs.BlogListResponse;
import dtos.response.blogs.BlogResponse;
import exceptions.DataNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class BlogService implements IBlogService{
    private final BlogRepository blogRepository;
    private final BlogCategoryRepository blogCategoryRepository;

    @Override
    public BlogListResponse getBlogs(int page, int size) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Blog> blogs = blogRepository.findAll(pageable);
        List<BlogResponse> blogResponses = blogs.getContent().stream().map(Blog::toResponse).toList();
        return BlogListResponse.builder()
                .blogs(blogResponses)
                .page(blogs.getTotalPages())
                .quantity(blogResponses.size())
                .build();
    }

    @Override
    public BlogResponse getBlog(Long id) {
       if(blogRepository.existsById(id))
           return Blog.toResponse(blogRepository.findById(id).get());
       return null;
    }

    @Override
    public BlogResponse createOrUpdate(BlogDTO blogDTO) {
        Blog blog = Blog.fromDTO(blogDTO);
        Blog savedBlog ;
        int isUpdate = 0;
        if(blogDTO.getId()!=null && blogRepository.existsById(blogDTO.getId())){
            blog.setId(blogDTO.getId());
        }
        savedBlog = blogRepository.save(blog);
        return Blog.toResponse(savedBlog);
    }

    @Override
    public BlogResponse delete(Long id) {
        if(blogRepository.existsById(id)){
            blogRepository.deleteById(id);
            return Blog.toResponse(blogRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public BlogListResponse getBlogsByKeyword(String keyword, int page, int size) {
        Page<Blog> results = blogRepository.findAllByKeyword(keyword,
                PageRequest.of(page,size,Sort.by(Sort.Direction.DESC,"createdDate")));
        List<BlogResponse> blogResponses = results.getContent().stream().map(Blog::toResponse).toList();
        return BlogListResponse.builder()
                .blogs(blogResponses)
                .page(results.getTotalPages())
                .quantity(blogResponses.size())
                .build();
    }

    @Override
    public BlogCategoryListResponse getBlogCategories() {
        List<BlogCategoryResponse>  responses = blogCategoryRepository.findAll()
                .stream().map(BlogCategory::toResponse).toList();
        return BlogCategoryListResponse.builder()
                .categories(responses)
                .build();
    }
}
