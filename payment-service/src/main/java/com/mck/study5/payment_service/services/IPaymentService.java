package com.mck.study5.payment_service.services;


import com.mck.study5.payment_service.dtos.PaymentListResponse;
import com.mck.study5.payment_service.dtos.PaymentRequest;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

public interface IPaymentService {
    PaymentListResponse getAllPaymentsByUserId(Long userId);
    String createPayment(PaymentRequest dto, Long userId);
    void cancelPayment(Long paymentId);
    RedirectView handleVnPayReturn(Map<String, String> params);
    String createPaymentUrlByPayOs(PaymentRequest dto, Long userId);
    RedirectView handlePayPalReturn(Map<String, String> params);
}
