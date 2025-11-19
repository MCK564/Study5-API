package com.mck.study5.auth_service.kafka.events;

import lombok.Builder;

@Builder
public record UserInfoCreateEvent(
        Long id,
        String name,
        String email,
        String picture,
        String sub,
        String local
) {
}
