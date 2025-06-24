package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Table(name="blog_category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogCategory extends BaseEntity{
    private String name;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Blog> blogs = new HashSet<>();
}
