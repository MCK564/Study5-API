package com.mck.study5.user_service.controllers;

import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.dtos.requests.ScheduleRequestDTO;
import com.mck.study5.user_service.dtos.responses.ApiResponse;
import com.mck.study5.user_service.services.schedules.IScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users/me/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final IScheduleService scheduleService;

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> getSchedule(@RequestHeader(value="X-User-Id", required = true) Long userId){
       return ResponseEntity.ok(ApiResponse.success(scheduleService.getAllOwnSchedule(userId), 200, MessageKeys.SUCCESS));
    }


    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> createSchedule(
            @RequestHeader(value="X-User-Id", required = true) Long userId,
            @RequestBody ScheduleRequestDTO dto
    ){
        return ResponseEntity.ok(ApiResponse.success(scheduleService.createOrUpdateSchedule(dto,userId), 200, MessageKeys.SUCCESS));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> deleteSchedule(
            @RequestHeader(value="X-User-Id", required = true) Long userId,
            @PathVariable Long id
    ){
        return ResponseEntity.ok(ApiResponse.success(scheduleService.deleteScheduleById(userId, id), 200, MessageKeys.SUCCESS));
    }

}
