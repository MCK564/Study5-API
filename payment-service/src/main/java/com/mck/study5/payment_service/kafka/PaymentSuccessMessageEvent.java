package com.mck.study5.payment_service.kafka;


import lombok.Builder;

@Builder
public record PaymentSuccessMessageEvent
        (
                Long userId,
                Long courseId,
                Long paymentId,
                String createdDate,
                String description
        )
{
}
