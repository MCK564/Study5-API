package com.mck.study5.upload_service.kafka.events;

import lombok.Builder;
import lombok.Setter;

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
