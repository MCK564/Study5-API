package com.mck.study5.product_service.responses.blogs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogResponse {
    private Long id;
    private String title;
    private String subtitle;
    private String content;
    private String writer;
    private Long views;
    private String keyword;
}
