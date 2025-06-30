package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
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
