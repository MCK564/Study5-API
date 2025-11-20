package com.mck.study5.product_service.controllers;

import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.dtos.request.word.WordDTO;
import com.mck.study5.product_service.responses.ApiResponse;
import com.mck.study5.product_service.services.word.IWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/products/words")
@RequiredArgsConstructor
public class WordController {
    private final IWordService  wordService;

    @GetMapping("/search")
    @PreAuthorize("hasAnRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> findWordByCondition(
            @RequestParam(value="page", defaultValue = "1")Integer page,
            @RequestParam(value="limit", defaultValue= "30")Integer limit,
            @RequestParam String keyword,
            @RequestParam(value="flashcard_id", required = true)Long flashcardId
            ){
       return ResponseEntity.ok(ApiResponse.success(wordService.findAllByConditions(page,limit,keyword,flashcardId),200, MessageKeys.SUCCESS));
    }

    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> createOrUpdate(
            @RequestBody WordDTO dto){
        return ResponseEntity.ok(ApiResponse.success(wordService.createOrUpdateWord(dto),200, MessageKeys.SUCCESS));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> deleteById(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(ApiResponse.success(wordService.deleteWord(id),200, MessageKeys.DELETE_SUCCESSFULLY));
    }


}
