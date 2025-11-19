package com.mck.study5.user_service.controllers;

import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.dtos.requests.TodoListRequestDTO;
import com.mck.study5.user_service.dtos.responses.ApiResponse;
import com.mck.study5.user_service.services.todoList.ITodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("")
@RequiredArgsConstructor
public class TodoListController {
    private final ITodoListService todoListService;

    @GetMapping("/users/me/schedule/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> getList(
            @RequestHeader(value="X-User-Id", required = true)String userId,
            @RequestHeader(value="X-User-Role", required = true)String role,
            @PathVariable Long id
    ){
        if(userId == null || role == null)return ResponseEntity.ok(ApiResponse.failure(null, 401, MessageKeys.UNAUTHORIZED));
        return ResponseEntity.ok(ApiResponse.success(todoListService.getAllByScheduleId(id), 200, MessageKeys.SUCCESS));
    }

    @PostMapping("/users/me/schedule/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> createOrUpdateTodoList(
            @RequestHeader(value="X-User-Id", required = true)String userId,
            @RequestHeader(value="X-User-Role", required = true)String role,
            @PathVariable Long id,
            @RequestBody TodoListRequestDTO dto
    ){
        if(userId == null || role == null)return ResponseEntity.ok(ApiResponse.failure(null, 401, MessageKeys.UNAUTHORIZED));
        return ResponseEntity.ok(ApiResponse.success(todoListService.createOrUpdateTodoList(dto, id), 200, MessageKeys.SUCCESS));
    }

    @DeleteMapping("/users/me/schedule/{scheduleId}/todoList/{todoListId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> deleteTodoList(
            @RequestHeader(value="X-User-Id", required = true)String userId,
            @RequestHeader(value="X-User-Role", required = true)String role,
            @PathVariable Long scheduleId,
            @PathVariable Long todoListId
    ){
        if(userId == null || role == null)return ResponseEntity.ok(ApiResponse.failure(null, 401, MessageKeys.UNAUTHORIZED));
        return ResponseEntity.ok(ApiResponse.success(todoListService.deleteTodoList(todoListId), 200, MessageKeys.SUCCESS));
    }


}
