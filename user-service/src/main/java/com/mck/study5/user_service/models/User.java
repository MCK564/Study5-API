package com.mck.study5.user_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<TrainingHistory> trainingHistories = new ArrayList<>();

    private List<Integer> courses = new ArrayList<>();

    private String name;
    private String email;
    private String avatar;
    private String fog;
    private String banner;
    private Boolean status;

}
