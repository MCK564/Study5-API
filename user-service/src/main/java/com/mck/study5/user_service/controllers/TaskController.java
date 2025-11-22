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
@RequestMapping("/users/tasks")
@RequiredArgsConstructor
public class TaskController {
    private  final ITaskService taskService;

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> deleteTask(
            @RequestHeader(value="X-User-Id", required = true) Long userId,
            @RequestHeader(value="X-User-Role", required = true) String role,
            @PathVariable Long id
    ){
        return ResponseEntity.ok(ApiResponse.success(taskService.deleteTaskById(id), 200, MessageKeys.DELETE_SUCCESSFULLY));
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> findByTodoListId(
           @RequestParam Long todoListId
    ){
        return ResponseEntity.ok(ApiResponse.success(taskService.findAllByTodoListId(todoListId), 200, MessageKeys.SUCCESS));
    }

    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> createOrUpdateTask(
            @RequestBody TaskRequestDTO dto)
    {
        return ResponseEntity.ok(ApiResponse.success(taskService.createOrUpdate(dto), 200, MessageKeys.SUCCESS));
    }

}
