package com.mck.study5.user_service.services.todoList;

import com.mck.study5.user_service.dtos.requests.TodoListRequestDTO;
import com.mck.study5.user_service.dtos.responses.todoList.ListTodoListResponse;
import com.mck.study5.user_service.dtos.responses.todoList.TodoListResponse;
import org.springframework.stereotype.Service;


public interface ITodoListService {
    ListTodoListResponse getAllByScheduleId(Long scheduleId);
    TodoListResponse createOrUpdateTodoList(TodoListRequestDTO dto);
    String deleteTodoList( Long id);
}
