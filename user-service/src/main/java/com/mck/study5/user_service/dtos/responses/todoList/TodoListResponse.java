package com.mck.study5.user_service.dtos.responses.todoList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.user_service.dtos.responses.tasks.TaskResponse;
import com.mck.study5.user_service.models.TodoList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoListResponse {
    private Long id;
    private String type;
    @JsonProperty("implemented_day")
    private String implementedDay;
    private Integer status;
    private String title;
    private List<TaskResponse> tasks = new ArrayList<>();

    public static TodoListResponse fromTodoList(TodoList todoList){
        return TodoListResponse.builder()
                .id(todoList.getId())
                .type(todoList.getType())
                .implementedDay(todoList.getImplementedDay())
                .status(todoList.getStatus())
                .title(todoList.getTitle())
                .tasks(todoList.getTasks().stream()
                        .map(TaskResponse::fromTask)
                        .toList())
                .build();
    }
}
