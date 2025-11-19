package com.mck.study5.user_service.services.schedules;

import com.mck.study5.user_service.dtos.requests.ScheduleRequestDTO;
import com.mck.study5.user_service.dtos.responses.schedules.ListScheduleResponse;
import com.mck.study5.user_service.dtos.responses.schedules.ScheduleResponse;
import org.springframework.stereotype.Service;


public interface IScheduleService {
    ScheduleResponse createOrUpdateSchedule(ScheduleRequestDTO dto);
    ListScheduleResponse getAllOwnSchedule(Long userId);
    String deleteScheduleById(Long userId, Long ScheduleId );
}
