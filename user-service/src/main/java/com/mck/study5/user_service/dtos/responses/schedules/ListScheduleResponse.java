package com.mck.study5.user_service.dtos.responses.schedules;


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
public class ListScheduleResponse {

    @JsonProperty("total_schedule")
    private Integer totalSchedule;

    @JsonProperty("list_schedule")
    private List<ScheduleResponse> scheduleResponses = new ArrayList<>();
}
