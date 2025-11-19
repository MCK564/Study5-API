package com.mck.study5.user_service.converter;

import com.mck.study5.user_service.dtos.requests.ScheduleRequestDTO;
import com.mck.study5.user_service.dtos.requests.TodoListRequestDTO;
import com.mck.study5.user_service.models.Schedule;
import com.mck.study5.user_service.models.TodoList;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Converter {
    private final ModelMapper modelMapper;

    public Schedule toSchedule(ScheduleRequestDTO dto){
        return modelMapper.map(dto, Schedule.class);
    }
    public TodoList toTodoList(TodoListRequestDTO dto){return modelMapper.map(dto, TodoList.class);}
}
