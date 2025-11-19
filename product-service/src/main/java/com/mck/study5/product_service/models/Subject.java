package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mck.study5.product_service.responses.subject.SubjectResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="subjects")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Subject extends BaseEntity{
    private String name;

    @OneToMany(mappedBy = "subject", fetch= FetchType.LAZY)
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    public static SubjectResponse toResponse(Subject subject){
        return SubjectResponse.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();
    }
}
