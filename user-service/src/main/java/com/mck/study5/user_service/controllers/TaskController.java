package com.mck.study5.user_service.controllers;

import com.mck.study5.user_service.services.tasks.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("${api.prefix}/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final ITaskService taskService;


}
