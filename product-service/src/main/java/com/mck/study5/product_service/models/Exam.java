package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mck.study5.product_service.enums.ExamType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name="exams")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private ExamType type;

    private String title;
    private String info;
    private Integer time;
    private Integer part;
    private Integer totalScore;
    private Boolean completed;
    private Integer numberOfCompletion;
    private Integer numberOfQuestion;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonManagedReference
    private ExamCategory category;
}
