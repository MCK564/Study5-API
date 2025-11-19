package com.mck.study5.user_service.services.tasks;


import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.dtos.requests.TaskRequestDTO;
import com.mck.study5.user_service.dtos.responses.tasks.ListTaskResponse;
import com.mck.study5.user_service.dtos.responses.tasks.TaskResponse;
import com.mck.study5.user_service.exceptions.DataNotFoundException;
import com.mck.study5.user_service.models.Task;
import com.mck.study5.user_service.models.TodoList;
import com.mck.study5.user_service.repositories.TaskRepository;
import com.mck.study5.user_service.repositories.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService{
    private final TaskRepository taskRepository;
    private final TodoListRepository todoListRepository;

    @Override
    public ListTaskResponse findAllByTodoListId(Long todoListId) {
        List<TaskResponse> taskResponses = taskRepository.findAllByTodoList_Id(todoListId)
                .stream()
                .map(TaskResponse::fromTask)
                .toList();

        return ListTaskResponse.builder()
                .build();
    }

    @Override
    public String deleteTaskById(Long id) {
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return MessageKeys.DELETE_SUCCESSFULLY+"task with id = "+ id;
        }
        return MessageKeys.EMPTY_REQUEST+": not found task with id = "+ id;
    }

    @Override
    public TaskResponse findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException(MessageKeys.DATA_NOT_FOUND+": task with id = "+ id));

        return TaskResponse.fromTask(task);
    }

    @Override
    public TaskResponse createOrUpdate(TaskRequestDTO dto, Long todoListId) {
        Task newTask;
        if(dto.getId()==null){
            newTask = new Task();
            newTask.setContent(dto.getContent());
            TodoList existedTodoList = todoListRepository.findById(todoListId)
                    .orElseThrow(()-> new DataNotFoundException(MessageKeys.DATA_NOT_FOUND+": todoList with id = "+ todoListId+""));
            newTask.setTodoList(existedTodoList);
        }
        else{
            newTask = taskRepository.findById(dto.getId())
                    .orElseThrow(()->  new DataNotFoundException(MessageKeys.DATA_NOT_FOUND+": task with id = "+ dto.getId()));
        }

        Task savedTask = taskRepository.save(newTask);
        return TaskResponse.fromTask(savedTask);
    }


}
