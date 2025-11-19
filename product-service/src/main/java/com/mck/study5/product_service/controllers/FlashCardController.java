package com.mck.study5.product_service.controllers;

import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.dtos.request.flashcard.FlashCardDTO;
import com.mck.study5.product_service.responses.ApiResponse;
import com.mck.study5.product_service.services.flashcards.IFlashCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/flashcards")
@RequiredArgsConstructor
public class FlashCardController {
    private final IFlashCardService flashCardService;

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> findFlashCardByKeyword(
            @RequestParam(value="keyword", required = false)String keyword,
            @RequestParam(value="page", defaultValue = "1")Integer page,
            @RequestParam(value="limit", defaultValue ="20")Integer limit){
        return ResponseEntity.ok(ApiResponse.success(flashCardService.findAllByKeyword(keyword,page,limit),200, MessageKeys.SUCCESS));}

    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> createOrUpdateFlashcard(
            @RequestBody FlashCardDTO flashCardDTO
    ){
        return ResponseEntity.ok(ApiResponse.success(flashCardService.createOrUpdate(flashCardDTO),200, MessageKeys.SUCCESS));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> deleteFlashcard(
            @PathVariable Long id
    ){
        if(id == null || id <= 0)return ResponseEntity.ok(ApiResponse.failure(null,200,MessageKeys.DATA_NOT_FOUND));
       return ResponseEntity.ok(ApiResponse.success(flashCardService.deleteById(id),200, MessageKeys.DELETE_SUCCESSFULLY));
    }




}
