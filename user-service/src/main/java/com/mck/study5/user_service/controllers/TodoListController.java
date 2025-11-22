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
@RequestMapping("/users/me/todoList")
@RequiredArgsConstructor
public class TodoListController {
    private final ITodoListService todoListService;

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> getList(
            @RequestParam(value="scheduleId", required = true)Long id
    ){
        return ResponseEntity.ok(ApiResponse.success(todoListService.getAllByScheduleId(id), 200, MessageKeys.SUCCESS));
    }

    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> createOrUpdateTodoList(
            @RequestBody TodoListRequestDTO dto
    ){
        return ResponseEntity.ok(ApiResponse.success(todoListService.createOrUpdateTodoList(dto), 200, MessageKeys.SUCCESS));
    }

    @DeleteMapping("/{todoListId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> deleteTodoList(
            @PathVariable Long todoListId
    ){
        return ResponseEntity.ok(ApiResponse.success(todoListService.deleteTodoList(todoListId), 200, MessageKeys.SUCCESS));
    }


}
