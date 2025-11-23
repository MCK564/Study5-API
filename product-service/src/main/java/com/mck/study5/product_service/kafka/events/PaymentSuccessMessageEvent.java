package com.mck.study5.product_service.kafka.events;


import lombok.Builder;

@Builder
public record PaymentSuccessMessageEvent
        (
                Long userId,
                Long courseId,
                Long paymentId,
                String email,
                String createdDate,
                String description
        )
{
}
