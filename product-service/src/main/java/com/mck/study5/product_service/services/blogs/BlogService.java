package com.mck.study5.product_service.services.blogs;

import com.mck.study5.product_service.converter.Converter;
import com.mck.study5.product_service.models.Blog;
import com.mck.study5.product_service.models.BlogCategory;
import com.mck.study5.product_service.repositories.BlogCategoryRepository;
import com.mck.study5.product_service.repositories.BlogRepository;
import com.mck.study5.product_service.dtos.request.blog.BlogCategoryDTO;
import com.mck.study5.product_service.dtos.request.blog.BlogDTO;
import com.mck.study5.product_service.responses.blogs.BlogCategoryListResponse;
import com.mck.study5.product_service.responses.blogs.BlogCategoryResponse;
import com.mck.study5.product_service.responses.blogs.BlogListResponse;
import com.mck.study5.product_service.responses.blogs.BlogResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService implements IBlogService{
    private final BlogRepository blogRepository;
    private final BlogCategoryRepository blogCategoryRepository;
    private final Converter converter;

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
    @Cacheable(value="redisBlog", key = "#id")
    public BlogResponse getBlog(Long id) {
       if(blogRepository.existsById(id)){
           Blog existingBlog = blogRepository.findById(id).get();
           existingBlog.setViews(existingBlog.getViews() + 1);
           blogRepository.save(existingBlog);
           return Blog.toResponse(existingBlog);
       }
       return null;
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value  = "redisBlog" , key = "#blogDTO.id", condition = "#blogDTO.id != null"),
            },
            put  = {
                    @CachePut(value = "redisBlog", key = "#blogDTO.id" , condition = "#blogDTO.id != null")
            }
    )
    public BlogResponse createOrUpdate(BlogDTO blogDTO) {
        Blog blog;
        if(blogDTO.getId()!=null) blog = blogRepository.findById(blogDTO.getId()).get();
        else blog = converter.fromBlogDTO(blogDTO);

        blog.setCategory(blogCategoryRepository.findById(blogDTO.getCategoryId()).get());
        Blog savedBlog = blogRepository.save(blog);
        return Blog.toResponse(savedBlog);
    }

    @Override
    @CacheEvict(value = {"redisBlog","redisBlogs"}, allEntries = true)
    public BlogResponse delete(Long id) {
        if(blogRepository.existsById(id)){
            blogRepository.deleteById(id);
            return Blog.toResponse(blogRepository.findById(id).get());
        }
        return null;
    }

    @Override
    @Cacheable(value = "redisBlogs", key = "#keyword+'_' +#page + '_'+ #size")
    public BlogListResponse getBlogsByKeyword(String keyword, int page, int size) {
        Page<Blog> results = blogRepository.searchByKeyword(keyword,
                PageRequest.of(page-1,size,Sort.by(Sort.Direction.DESC,"createdDate")));
        List<BlogResponse> blogResponses = results.getContent().stream().map(Blog::toResponse).toList();
        return BlogListResponse.builder()
                .blogs(blogResponses)
                .page(results.getTotalPages())
                .quantity(blogResponses.size())
                .build();
    }

    @Override
    @Cacheable(value = "redisBlogCategories", key = "1")
    public BlogCategoryListResponse getBlogCategories() {
        List<BlogCategoryResponse>  responses = blogCategoryRepository
                .findAll()
                .stream()
                .map(BlogCategory::toResponse)
                .toList();

        return BlogCategoryListResponse.builder()
                .categories(responses)
                .build();
    }

    @Override
    @CacheEvict(value = {"redisBlogCategories"}, allEntries = true)
    public BlogCategoryResponse createOrUpdateCategory(BlogCategoryDTO dto) {
        BlogCategory category ;
        if(dto.getId()!=null){
            category = blogCategoryRepository.findById(dto.getId()).get();
            category.setName(dto.getName());

        }
        else{
            category = BlogCategory.builder()
                    .name(dto.getName())
                    .build();
        }
        blogCategoryRepository.save(category);
        return BlogCategory.toResponse(category);
    }

    @Override
    public BlogCategoryResponse deleteCategory(Long id) {
        BlogCategoryResponse response = BlogCategory.toResponse(blogCategoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Category not found")));
        blogCategoryRepository.deleteById(id);
        return response;
    }

    @Override
    public void updateBlogImage(Long blogId, String imageUrl, Long imageId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(()-> new EntityNotFoundException("Blog not found"));
        blog.setThumbnailId(imageId);
        blog.setThumbnail(imageUrl);
        blogRepository.save(blog);
    }

    @Override
    @CacheEvict(value = {"redisBlog","redisBlogs"}, allEntries = true)
    public void evictBlogCache(Long id) {
    }
}
