package com.mck.study5.user_service.services.todoList;

import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.converter.Converter;
import com.mck.study5.user_service.dtos.requests.TodoListRequestDTO;
import com.mck.study5.user_service.dtos.responses.todoList.ListTodoListResponse;
import com.mck.study5.user_service.dtos.responses.todoList.TodoListResponse;
import com.mck.study5.user_service.enums.TodoListType;
import com.mck.study5.user_service.models.TodoList;
import com.mck.study5.user_service.repositories.ScheduleRepository;
import com.mck.study5.user_service.repositories.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoListService implements ITodoListService{
    private final TodoListRepository todoListRepository;
    private final Converter converter;
    private final ScheduleRepository scheduleRepository;


    @Override
    public ListTodoListResponse getAllByScheduleId(Long scheduleId) {
        List<TodoListResponse> list = todoListRepository.findAllBySchedule_Id(scheduleId)
                .stream()
                .map(TodoListResponse::fromTodoList)
                .toList();
        return ListTodoListResponse.builder()
                .totalTodoList(list.size())
                .todoListResponses(list)
                .build();
    }

    @Override
    public TodoListResponse createOrUpdateTodoList(TodoListRequestDTO dto) {
        TodoList newTodoList;
        if(dto.getId() != null && todoListRepository.existsById(dto.getId())){
            newTodoList =  todoListRepository.findById(dto.getId()).get();
            newTodoList.setType(dto.getType());

//            not completed, need to handle string from client .
            newTodoList.setImplementedDay(dto.getImplementedDay());
            newTodoList.setStatus(dto.getStatus());
            newTodoList.setTitle(dto.getTitle());
        }
        else{newTodoList = converter.toTodoList(dto);
            newTodoList.setSchedule(scheduleRepository.findById(dto.getScheduleId()).get());
        }
        TodoList savedTodoList = todoListRepository.save(newTodoList);
        return TodoListResponse.fromTodoList(savedTodoList);
    }

    @Override
    public String deleteTodoList(Long id) {
      if(todoListRepository.existsById(id)){
          todoListRepository.deleteById(id);
          return MessageKeys.DELETE_SUCCESSFULLY+"todoList with id = "+ id;
      }
      return MessageKeys.EMPTY_REQUEST+": no todoList with id = "+id;
    }


}
