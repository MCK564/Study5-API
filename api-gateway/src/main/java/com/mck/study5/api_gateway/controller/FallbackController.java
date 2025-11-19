package com.mck.study5.api_gateway.controller;


import com.mck.study5.api_gateway.constants.MessageKeys;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/fallback-response")
    public Mono<ResponseEntity<String>> fallbackResponse() {
        return Mono.just(ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(MessageKeys.SERVICE_UNAVAILABLE));
    }

    @GetMapping("/fallback-error")
    public Mono<ResponseEntity<String>> fallbackError() {
        return Mono.error(new RuntimeException(MessageKeys.DELETE_SUCCESSFULLY));
    }
}
