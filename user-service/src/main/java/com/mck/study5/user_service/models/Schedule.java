package com.mck.study5.user_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="schedules")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule extends BaseEntity{

    private String title;
    private String description;

    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<TodoList> todoLists = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;
    private String status;

}
