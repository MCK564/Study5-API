package com.mck.study5.product_service.models;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="blogs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog extends BaseEntity{
    private String title;
    private String subtitle;
    private String content;
    private String writer;
    private List<String> keywords;


}
