package com.mck.study5.notification_service.kafka.event;


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
