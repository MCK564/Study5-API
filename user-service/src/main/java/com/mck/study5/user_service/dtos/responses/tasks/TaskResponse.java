package com.mck.study5.user_service.dtos.responses.tasks;

import com.mck.study5.user_service.models.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {
    private Long id;
    private String content;


    public static TaskResponse fromTask(Task task){
        return TaskResponse.builder()
                .id(task.getId())
                .content(task.getContent())
                .build();
    }
}
