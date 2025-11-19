package com.mck.study5.user_service.controllers;


import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.dtos.responses.ApiResponse;
import com.mck.study5.user_service.dtos.responses.trainingHistory.ListTrainingHistoryResponse;
import com.mck.study5.user_service.services.trainingHistory.ITrainingHistoryService;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.asn1.ocsp.ResponderID;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users/training-history")
@RequiredArgsConstructor
public class TrainingHistoryController {
    private final ITrainingHistoryService trainingHistoryService;

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<ListTrainingHistoryResponse>> findTrainingHistory(
            @RequestHeader(value="X-User-Id", required = true)String userId,
            @RequestHeader(value="X-User-Role", required = true)String role
    ){
        if(userId == null || role == null)return ResponseEntity.ok(ApiResponse.failure(null, 401, MessageKeys.UNAUTHORIZED));
        return ResponseEntity.ok(ApiResponse.success(null, 200, MessageKeys.SUCCESS));
    }


}
