package com.mck.study5.user_service.kafka.events;


import lombok.Builder;

@Builder
public record MediaDeletedEvent(
        Long imageId,
        String url,
        Long ownerId,
        String  ownerType,  // USER / PRODUCT / LESSON...
        String mediaKind,       // IMAGE / AUDIO / VIDEO
        String mediaUsage  ) { }
