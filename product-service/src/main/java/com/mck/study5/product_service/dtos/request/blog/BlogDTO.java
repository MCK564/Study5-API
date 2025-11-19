package com.mck.study5.product_service.dtos.request.blog;

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
    private String writer;
    private Long views;
    private List<String> keywords;
}
