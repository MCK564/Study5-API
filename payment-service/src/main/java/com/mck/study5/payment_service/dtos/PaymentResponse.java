package com.mck.study5.payment_service.dtos;

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
    private Long paymentId;
    private String description;
    private String email;
    private Long courseId;
    private PaymentStatus paymentStatus;
    private String bank;
    private LocalDateTime createdDate;
    private String createdBy;
    private Long price;
}
