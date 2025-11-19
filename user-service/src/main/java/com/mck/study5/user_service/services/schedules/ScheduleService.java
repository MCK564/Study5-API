package com.mck.study5.user_service.services.schedules;


import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.converter.Converter;
import com.mck.study5.user_service.dtos.requests.ScheduleRequestDTO;
import com.mck.study5.user_service.dtos.responses.schedules.ListScheduleResponse;
import com.mck.study5.user_service.dtos.responses.schedules.ScheduleResponse;
import com.mck.study5.user_service.models.Schedule;
import com.mck.study5.user_service.repositories.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService implements IScheduleService{
    private final ScheduleRepository scheduleRepository;
    private final Converter converter;


    @Override
    public ScheduleResponse createOrUpdateSchedule(ScheduleRequestDTO dto) {
        Schedule newSchedule;
        if(dto.getId() != null && scheduleRepository.existsById(dto.getId())){
            newSchedule = scheduleRepository.findById(dto.getId()).get();
            newSchedule.setDescription(dto.getDescription());
            newSchedule.setTitle(dto.getTitle());
            newSchedule.setStatus(dto.getStatus());

        }
        else{newSchedule = converter.toSchedule(dto);}
        Schedule savedSchedule = scheduleRepository.save(newSchedule);

        return ScheduleResponse.fromSchedule(savedSchedule);
    }

    @Override
    public ListScheduleResponse getAllOwnSchedule(Long userId) {

       List<ScheduleResponse> list = scheduleRepository
               .findAllByUser_Id(userId)
               .stream().map(ScheduleResponse::fromSchedule)
               .toList();

       return ListScheduleResponse.builder()
               .totalSchedule(list.size())
               .scheduleResponses(list)
               .build();
    }

    @Override
    public String deleteScheduleById(Long userId, Long scheduleId) {
        if(scheduleRepository.existsById(scheduleId)){
            Long id = scheduleRepository.findById(scheduleId).get().getUser().getId();
            if(id != userId){return MessageKeys.UNAUTHORIZED+": no permission for other schedule except owns";}
            scheduleRepository.deleteById(scheduleId);
            return MessageKeys.DELETE_SUCCESSFULLY+"schedule with id = "+ id;
        }
        return MessageKeys.EMPTY_REQUEST+": no schedule with id = "+scheduleId;
    }
}
