package com.mck.study5.user_service.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {
    private Long id;
    private String content;

    @JsonProperty("todo_list_id")
    private Long todoListId;
}
