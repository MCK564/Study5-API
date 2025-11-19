package com.mck.study5.user_service.controllers;

import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.dtos.requests.TaskRequestDTO;
import com.mck.study5.user_service.dtos.responses.ApiResponse;
import com.mck.study5.user_service.services.tasks.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("")
@RequiredArgsConstructor
public class TaskController {
    private  final ITaskService taskService;

    @DeleteMapping("users/tasks/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> deleteTask(
            @RequestHeader(value="X-User-Id", required = true) String userId,
            @RequestHeader(value="X-User-Role", required = true) String role,
            @PathVariable Long id
    ){
        if(userId == null || role == null)return ResponseEntity.ok(ApiResponse.failure(null, 401, MessageKeys.UNAUTHORIZED));
        return ResponseEntity.ok(ApiResponse.success(taskService.deleteTaskById(id), 200, MessageKeys.DELETE_SUCCESSFULLY));
    }

    @GetMapping("/users/me/schedule/{scheduleId}/todo_list/{todoListId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> deleteTask(
            @RequestHeader(value="X-User-Id", required = true) String userId,
            @RequestHeader(value="X-User-Role", required = true) String role,
            @PathVariable Long scheduleId,
            @PathVariable Long todoListId
    ){
        if(userId == null || role == null)return ResponseEntity.ok(ApiResponse.failure(null, 401, MessageKeys.UNAUTHORIZED));
        return ResponseEntity.ok(ApiResponse.success(taskService.findAllByTodoListId(todoListId), 200, MessageKeys.SUCCESS));
    }

    @PostMapping("/users/me/schedule/{scheduleId}/todo_list/{todoListId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> createOrUpdateTask(
            @RequestHeader(value="X-User-Id", required = true) String userId,
            @RequestHeader(value="X-User-Role", required = true) String role,
            @PathVariable Long scheduleId,
            @PathVariable Long todoListId,
            @RequestBody TaskRequestDTO dto)
    {
        if(userId == null || role == null)return ResponseEntity.ok(ApiResponse.failure(null, 401, MessageKeys.UNAUTHORIZED));
        return ResponseEntity.ok(ApiResponse.success(taskService.createOrUpdate(dto, todoListId), 200, MessageKeys.SUCCESS));
    }

}
