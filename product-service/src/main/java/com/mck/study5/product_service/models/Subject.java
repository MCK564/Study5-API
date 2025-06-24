package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name="blogs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject extends BaseEntity{
    private String name;

    @OneToMany(mappedBy = "subject", fetch= FetchType.LAZY)
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();
}
