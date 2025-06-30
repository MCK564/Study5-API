package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mck.study5.product_service.enums.ExamType;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="exams")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam extends BaseEntity{

    private ExamType type;
    private String title;
    private String info;
    private Integer time;
    private Integer part;
    private Integer totalScore;
    private Boolean completed;
    private Integer numberOfCompletion;
    private Integer numberOfQuestion;
    private String term;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonManagedReference
    private ExamCategory category;
}
