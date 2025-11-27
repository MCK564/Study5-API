package com.mck.study5.payment_service.services;


import com.mck.study5.payment_service.clients.CourseClient;
import com.mck.study5.payment_service.config.VNPayConfig;
import com.mck.study5.payment_service.constants.MessageKeys;
import com.mck.study5.payment_service.converter.Converter;
import com.mck.study5.payment_service.dtos.PaymentListResponse;
import com.mck.study5.payment_service.dtos.PaymentRequest;
import com.mck.study5.payment_service.dtos.PaymentResponse;
import com.mck.study5.payment_service.exceptions.CourseAlreadyPurchaseException;
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
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {
    private final PaymentRepository paymentRepository;
    private final VNPayConfig vNPayConfig;
    private final Converter converter;
    private final KafkaProducer kafkaProducer;
    private final PayOSService payOSService;
    private final CourseClient  courseClient;

    @Value("${vnpay.return_client_url}")
    private String returnClientUrl;

    @Override
    public PaymentListResponse getAllPaymentsByUserId(Long userId) {
        List<PaymentResponse> responses = paymentRepository.findAllByUserId(userId)
                .stream().map(PaymentResponse::fromPayment).toList();
        return PaymentListResponse.builder()
                .payments(responses).build();
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
            return vNPayConfig.createPaymentUrl(savedPayment);
        } catch (Exception e) {
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

    @Override
    public String createPaymentUrlByPayOs(PaymentRequest dto, Long userId) {
//        Boolean unlocked = courseClient.checkCourseUnlock(userId, dto.getCourseId());
//        if (Boolean.TRUE.equals(unlocked)) {
//            throw new CourseAlreadyPurchaseException("Course already purchased / unlocked.");
//        }
        Payment newPayment = Payment.builder()
                .courseId(dto.getCourseId())
                .price(dto.getPrice())
                .email(dto.getEmail())
                .userId(userId)
                .paymentStatus(PaymentStatus.PENDING.getStatus())
                .description(dto.getDescription())
                .build();
        Payment savedPayment = paymentRepository.save(newPayment);
        try {
            return payOSService.createPaymentLink(savedPayment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


//    code=00&id=b46af56d034d453eab8f60ac27e98360&cancel=false&status=PAID&orderCode=29
    @Override
    public RedirectView handlePayPalReturn(Map<String, String> params) {
        StringBuilder urlReturn = new StringBuilder(returnClientUrl);
       String paymentId = params.get("orderCode");
        Payment existedPayment = paymentRepository.findById(Long.valueOf(paymentId))
                .orElseThrow(()-> new RuntimeException("Payment not found"));
       if(params.get("code").equals("00") && params.get("status").equals("PAID")){

           existedPayment.setPaymentStatus(PaymentStatus.SUCCESS.getStatus());
           paymentRepository.save(existedPayment);
           PaymentSuccessMessageEvent event = PaymentSuccessMessageEvent.builder()
                   .email(existedPayment.getEmail())
                   .paymentId(existedPayment.getId())
                   .courseId(existedPayment.getCourseId())
                   .userId(existedPayment.getUserId())
                   .createdDate(existedPayment.getCreatedDate().toString())
                   .description(existedPayment.getDescription())
                   .build();

           kafkaProducer.publishPaymentSuccessMessage(event);
           urlReturn.append(MessageKeys.SUCCESS);
       }
       else{
           urlReturn.append(MessageKeys.FAILURE);
           paymentRepository.deleteById(existedPayment.getId());
       }
        return new RedirectView(urlReturn.toString());
    }


}
