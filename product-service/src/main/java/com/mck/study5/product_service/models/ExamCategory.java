package com.mck.study5.product_service.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name="exam_category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamCategory extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String content;

    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Exam> exams =  new HashSet<>();


}
