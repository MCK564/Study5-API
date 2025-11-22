package com.mck.study5.user_service.services.tasks;

import com.mck.study5.user_service.dtos.requests.TaskRequestDTO;
import com.mck.study5.user_service.dtos.responses.tasks.ListTaskResponse;
import com.mck.study5.user_service.dtos.responses.tasks.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface ITaskService {
    ListTaskResponse findAllByTodoListId(Long todoListId);
    String deleteTaskById(Long id);
    TaskResponse findById(Long id);
    TaskResponse createOrUpdate(TaskRequestDTO dto);
}
