package com.mck.study5.learning_service.kafka.events;

import lombok.Builder;

@Builder
public record MediaUploadedEvent(
        Long imageId,
        String url,
        Long ownerId,
        String ownerType,
        String mediaKind,
        String mediaUsage
) {
}
