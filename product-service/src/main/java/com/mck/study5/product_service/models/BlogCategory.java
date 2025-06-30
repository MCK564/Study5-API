package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dtos.response.blogs.BlogCategoryResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="blog_category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogCategory extends BaseEntity{
    private String name;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Blog> blogs = new HashSet<>();

    public static BlogCategoryResponse toResponse(BlogCategory blogCategory){
        return BlogCategoryResponse.builder()
                .id(blogCategory.getId())
                .name(blogCategory.getName())
                .build();

    }
}
