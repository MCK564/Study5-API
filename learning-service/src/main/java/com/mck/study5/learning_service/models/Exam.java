package com.mck.study5.learning_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="exams")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Exam extends BaseEntity{
    private String type;
    private String title;
    private String info;
    private Integer time;
    private Integer part;
    private Integer numberOfCompletion;
    private Integer numberOfQuestion;
    private String thumbnailUrl;
    private Long thumbnailId;
    private Long audioId;
    private String audioUrl;
    private String term;

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ExamAttempt> examAttempts  = new ArrayList<>();

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
    private List<Question> questions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonManagedReference
    private ExamCategory category;
}
