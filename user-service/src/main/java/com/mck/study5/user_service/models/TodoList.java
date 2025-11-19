package com.mck.study5.user_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mck.study5.user_service.enums.TodoListType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="todo_lists")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoList extends BaseEntity{

    private String title;
    private TodoListType type;
    private Integer status;

    private String implementedDay;

    @OneToMany(mappedBy = "todoList", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    @JsonManagedReference
    private Schedule schedule;
}
