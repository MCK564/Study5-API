package com.mck.study5.user_service.dtos.responses.todoList;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ListTodoListResponse {
    @JsonProperty("total_todo_list")
    private Integer totalTodoList;

    @JsonProperty("todo_lists")
    private List<TodoListResponse> todoListResponses = new ArrayList<>();
}
