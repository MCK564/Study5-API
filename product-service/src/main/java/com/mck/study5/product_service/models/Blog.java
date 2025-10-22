package com.mck.study5.product_service.models;


import com.mck.study5.product_service.dtos.request.blog.BlogDTO;
import dtos.response.blogs.BlogResponse;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="blogs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog extends BaseEntity{
    private String title;
    private String subtitle;
    private String content;
    private String writer;
    private Long views;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="blog_keywords",
            joinColumns = @JoinColumn(name = "blog_id")
    )
    @Column(name = "keyword")
    private List<String> keywords;

    public static BlogResponse toResponse(Blog blog)   {
        return BlogResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .subtitle(blog.getSubtitle())
                .content(blog.getContent())
                .writer(blog.getWriter())
                .keywords(blog.getKeywords())
                .views(blog.getViews())
                .build();
    }

    public static Blog fromDTO(BlogDTO blogDTO)   {
        return Blog.builder()
                .title(blogDTO.getTitle())
                .subtitle(blogDTO.getSubtitle())
                .content(blogDTO.getContent())
                .writer(blogDTO.getWriter())
                .keywords(blogDTO.getKeywords())
                .views(blogDTO.getViews())
                .build();
    }
}
