package com.mck.study5.user_service.dtos.responses.tasks;

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
public class ListTaskResponse {

    @JsonProperty("total_task")
    private Integer totalTask;
    private List<TaskResponse> tasks = new ArrayList<>();
}
