package com.mck.study5.product_service.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="lessons")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Lesson extends BaseEntity{
    private String title;
    private String description;
    private String thumbnail;
    private Long thumbnailId;
    private String video;
    private String videoId;
    private String transcript;

    @OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
    private List<Progress> progress = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    @JsonManagedReference
    private Course course;
}
