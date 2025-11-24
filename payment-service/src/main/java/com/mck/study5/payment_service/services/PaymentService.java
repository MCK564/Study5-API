package com.mck.study5.payment_service.services;


import com.mck.study5.payment_service.config.VNPayConfig;
import com.mck.study5.payment_service.constants.MessageKeys;
import com.mck.study5.payment_service.converter.Converter;
import com.mck.study5.payment_service.dtos.PaymentListResponse;
import com.mck.study5.payment_service.dtos.PaymentRequest;
import com.mck.study5.payment_service.kafka.KafkaProducer;
import com.mck.study5.payment_service.kafka.PaymentSuccessMessageEvent;
import com.mck.study5.payment_service.models.Payment;
import com.mck.study5.payment_service.models.PaymentStatus;
import com.mck.study5.payment_service.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {
    private final PaymentRepository paymentRepository;
    private final VNPayConfig vNPayConfig;
    private final Converter converter;
    private final KafkaProducer kafkaProducer;

    @Value("${vnpay.return_client_url}")
    private String returnClientUrl;

    @Override
    public PaymentListResponse getAllPaymentsByUserId(Long userId) {
        return null;
    }

    @Override
    public String createPayment(PaymentRequest dto, Long userId) {
        Payment newPayment = Payment.builder()
                .courseId(dto.getCourseId())
                .price(dto.getPrice())
                .email(dto.getEmail())
                .userId(userId)
                .description(dto.getDescription())
                .build();
        Payment savedPayment = paymentRepository.save(newPayment);
        try {
            return vNPayConfig.VNPayRequestUrl(dto, savedPayment);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cancelPayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public RedirectView handleVnPayReturn(Map<String, String> params) {
        StringBuilder urlReturn = new StringBuilder(returnClientUrl);
        String responseCode = params.get("vnp_ResponseCode");
        Long paymentId = Long.parseLong(params.get("vnp_TxnRef"));
        if(responseCode.equals("24")){
            urlReturn.append(MessageKeys.FAILURE);
        }
        // localhost:3000/payments/history?success=true
        else if(responseCode.equals("00")){
            Payment existingPayment = paymentRepository.findById(paymentId).get();
            existingPayment.setPaymentStatus(PaymentStatus.SUCCESS.getStatus());
            paymentRepository.saveAndFlush(existingPayment);
//          kafka send notification message

//            kafka send userEnrollmentEvent
            PaymentSuccessMessageEvent event = PaymentSuccessMessageEvent.builder()
                    .email(existingPayment.getEmail())
                    .paymentId(existingPayment.getId())
                    .courseId(existingPayment.getCourseId())
                    .userId(existingPayment.getUserId())
                    .createdDate(existingPayment.getCreatedDate().toString())
                    .description(existingPayment.getDescription())
                    .build();

            kafkaProducer.publishPaymentSuccessMessage(event);
            urlReturn.append(MessageKeys.SUCCESS);
        }
        return new RedirectView(urlReturn.toString());
    }
}
