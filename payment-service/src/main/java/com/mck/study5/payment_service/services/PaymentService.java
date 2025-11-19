package com.mck.study5.payment_service.services;


import com.mck.study5.payment_service.config.VNPayConfig;
import com.mck.study5.payment_service.constants.MessageKeys;
import com.mck.study5.payment_service.dtos.PaymentListResponse;
import com.mck.study5.payment_service.dtos.PaymentRequest;
import com.mck.study5.payment_service.models.Payment;
import com.mck.study5.payment_service.models.PaymentStatus;
import com.mck.study5.payment_service.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {
    private final PaymentRepository paymentRepository;
    private final VNPayConfig vNPayConfig;

    @Value("${vnpay.return_client_url}")
    private String returnClientUrl;

    @Override
    public PaymentListResponse getAllPaymentsByUserId(Long userId) {
        return null;
    }

    @Override
    public String createPayment(PaymentRequest dto) {
        return "";
    }

    @Override
    public void cancelPayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public RedirectView handleVnPayReturn(Map<String, String> params) {
        StringBuilder urlReturn = new StringBuilder(returnClientUrl);
        String responseCode = params.get("vnp_ResponseCode");
        Long orderId = Long.parseLong(params.get("vnp_TxnRef"));
        if(responseCode.equals("24")){
            urlReturn.append(MessageKeys.FAILURE);
        }
        else if(responseCode.equals("00")){
            Payment existingPayment = paymentRepository.findById(orderId).get();
            existingPayment.setPaymentStatus(PaymentStatus.SUCCESS);
            paymentRepository.saveAndFlush(existingPayment);
//          kafka send notification message
            urlReturn.append(MessageKeys.SUCCESS);
        }
        return new RedirectView(urlReturn.toString());
    }
}
