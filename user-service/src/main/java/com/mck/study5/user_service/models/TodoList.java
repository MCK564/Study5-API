package com.mck.study5.user_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mck.study5.user_service.enums.TodoListType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name="todo_lists")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TodoListType type;
    private Integer status;
    private String implementedDay;

    @OneToMany(mappedBy = "TodoList", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    @JsonManagedReference
    private Schedule schedule;
}
