package com.mck.study5.product_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/flashcards")
@RequiredArgsConstructor
public class FlashCardController {
}
