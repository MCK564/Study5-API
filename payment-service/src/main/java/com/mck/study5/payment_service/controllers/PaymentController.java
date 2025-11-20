package com.mck.study5.payment_service.controllers;


import com.mck.study5.payment_service.constants.MessageKeys;
import com.mck.study5.payment_service.dtos.PaymentRequest;
import com.mck.study5.payment_service.response.ApiResponse;
import com.mck.study5.payment_service.services.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final IPaymentService paymentService;

    @Value("${vnpay.return_client_url}")
    private String returnClientUrl;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }


    @PostMapping("/")
    public ResponseEntity<ApiResponse<?>> createPayment(
            @RequestHeader(value = "X-User-Id", required = true) String userId,
            @RequestHeader(value = "X-User-Role", required = true) String role,
            @RequestBody PaymentRequest dto
            ){
        if(userId == null || role == null){return ResponseEntity.ok(ApiResponse.failure(null,401, MessageKeys.UNAUTHORIZED));}
        return ResponseEntity.ok(ApiResponse.success(paymentService.createPayment(dto),200, MessageKeys.SUCCESS));}


    @GetMapping("/vnpay_return")
    public RedirectView handleVNPayReturn(@RequestParam Map<String,String> params){
        try{
            return paymentService.handleVnPayReturn(params);
        }catch(Exception e){
            return new RedirectView(returnClientUrl+"failed");
        }
    }

    @GetMapping("/history")
    public ResponseEntity<ApiResponse<?>> getAllPaymentsByUserId(
            @RequestHeader(value = "X-User-Id", required = true) String userId,
            @RequestHeader(value = "X-User-Role", required = true) String role){
        if(userId == null || role == null){return ResponseEntity.ok(ApiResponse.failure(null,401, MessageKeys.UNAUTHORIZED));}
        return ResponseEntity.ok(ApiResponse.success(paymentService.getAllPaymentsByUserId(Long.valueOf(userId)),200, MessageKeys.SUCCESS));}

//    admin/history
}
