package com.mck.study5.user_service.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("${api.prefix}/trainingHistory")
@RequiredArgsConstructor
public class TrainingHistoryController {
}
