package com.mck.study5.payment_service.controllers;


import com.mck.study5.payment_service.clients.CourseClient;
import com.mck.study5.payment_service.constants.MessageKeys;
import com.mck.study5.payment_service.dtos.PaymentRequest;
import com.mck.study5.payment_service.response.ApiResponse;
import com.mck.study5.payment_service.services.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final CourseClient courseClient;
    private final IPaymentService paymentService;

    @Value("${vnpay.return_client_url}")
    private String returnClientUrl;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> createPayment(
            @RequestHeader(value = "X-User-Id", required = true) Long userId,
            @RequestHeader(value = "X-User-Role", required = true) String role,
            @RequestBody PaymentRequest dto
            ){
        return ResponseEntity.ok(ApiResponse.success(paymentService.createPaymentUrlByPayOs(dto,userId),200, MessageKeys.SUCCESS));
    }


    @GetMapping("payos_return")
    public RedirectView handleVNPayReturn(@RequestParam Map<String,String> params){
        try{
            return paymentService.handlePayPalReturn(params);
        }catch(Exception e){
            return new RedirectView(returnClientUrl+MessageKeys.FAILURE);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/history")
    public ResponseEntity<ApiResponse<?>> getAllPaymentsByUserId(
            @RequestHeader(value = "X-User-Id", required = true) Long userId){
        return ResponseEntity.ok(ApiResponse.success(paymentService.getAllPaymentsByUserId(userId),200, MessageKeys.SUCCESS));}


}
