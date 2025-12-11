package com.mck.study5.product_service.dtos.request.blog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class BlogDTO {
    private Long id;
    private String title;
    private String subtitle;
    private String content;
    private Long views;
    private String writer;
    private String keywords;
    @JsonProperty("category_id")
    private Long categoryId;
}
