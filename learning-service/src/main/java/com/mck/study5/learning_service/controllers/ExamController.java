package com.mck.study5.learning_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/exams")
@RequiredArgsConstructor
public class ExamController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }


}
