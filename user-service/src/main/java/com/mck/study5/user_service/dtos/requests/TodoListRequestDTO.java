package com.mck.study5.user_service.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoListRequestDTO {
    private Long id;

    @JsonProperty("implemented_day")
    private String implementedDay;
    private String title;
    private String type;
    private Integer status;

    @JsonProperty("schedule_id")
    private Long scheduleId;
}
