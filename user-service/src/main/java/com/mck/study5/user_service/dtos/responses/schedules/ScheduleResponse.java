package com.mck.study5.user_service.dtos.responses.schedules;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.user_service.dtos.responses.todoList.TodoListResponse;
import com.mck.study5.user_service.models.Schedule;
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
public class ScheduleResponse {
    private Long id;
    private String title;
    private String description;
    private String status;
    @JsonProperty("created_date")
    private String createdDate;

    @JsonProperty("todo_list")
    private List<TodoListResponse> todoListResponse = new ArrayList<>();

    public static ScheduleResponse fromSchedule(Schedule schedule) {
        return ScheduleResponse.builder()
                .id(schedule.getId())
                .title(schedule.getTitle())
                .description(schedule.getDescription())
                .status(schedule.getStatus())
                .createdDate(schedule.getCreatedDate().toString())
                .todoListResponse(schedule.getTodoLists()
                        .stream()
                        .map(TodoListResponse::fromTodoList)
                        .toList())
                .build();
    }
}
