package com.mck.study5.payment_service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.payment_service.models.Payment;
import com.mck.study5.payment_service.models.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
    private Long id;
    private String description;
    private String email;
    @JsonProperty("course_id")
    private Long courseId;

    @JsonProperty("user_id")
    private Long userId;
    private String paymentStatus;
    private String bank;
    private LocalDateTime createdDate;
    private String createdBy;
    private Long price;

    public static PaymentResponse fromPayment(Payment payment){
        return PaymentResponse.builder()
                .id(payment.getId())
                .price(payment.getPrice())
                .courseId(payment.getCourseId())
                .paymentStatus(payment.getPaymentStatus())
                .email(payment.getEmail())
                .description(payment.getDescription())

                .build();
    }
}
