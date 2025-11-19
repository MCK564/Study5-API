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
@RequestMapping("")
@RequiredArgsConstructor
public class ScheduleController {
    private final IScheduleService scheduleService;

    @GetMapping("/users/me/schedule")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> getSchedule(@RequestHeader(value="X-User-Id", required = true) String userId){
       return ResponseEntity.ok(ApiResponse.success(scheduleService.getAllOwnSchedule(Long.valueOf(userId)), 200, MessageKeys.SUCCESS));
    }


    @PostMapping("/users/me/schedule")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> createSchedule(
            @RequestHeader(value="X-User-Id", required = true) String userId,
            @RequestBody ScheduleRequestDTO dto
    ){
        return ResponseEntity.ok(ApiResponse.success(scheduleService.createOrUpdateSchedule(dto), 200, MessageKeys.SUCCESS));
    }


    @DeleteMapping("/users/me/schedule/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> deleteSchedule(
            @RequestHeader(value="X-User-Id", required = true) String userId,
            @PathVariable Long id
    ){
        return ResponseEntity.ok(ApiResponse.success(scheduleService.deleteScheduleById(Long.valueOf(userId), id), 200, MessageKeys.SUCCESS));
    }

}
