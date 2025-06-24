package com.mck.study5.product_service.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="questions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question extends BaseEntity{
    private String script;
    private String question;
    private String transcript;

    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;


    private String detailedExplanation;


}
