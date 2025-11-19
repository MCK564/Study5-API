package com.mck.study5.auth_service.kafka;


import com.mck.study5.auth_service.kafka.events.UserInfoCreateEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserEventPublisher {
    private final KafkaTemplate<String, UserInfoCreateEvent> userSignupKafkaTemplate;

    @Value("${spring.kafka.topics.user-created}")
    private String userCreatedTopic;

    public CompletableFuture<Void> publishUserCreated(UserInfoCreateEvent event) {
        return userSignupKafkaTemplate
                .send(userCreatedTopic, event.email(), event)
                .thenAccept(result -> {
                    var meta = result.getRecordMetadata();
                    log.info(
                            ">>> Sent UserInfoCreateEvent to topic={} partition={} offset={}",
                            meta.topic(), meta.partition(), meta.offset()
                    );
                })
                .exceptionally(ex -> {
                    log.error(">>> Failed to send UserInfoCreateEvent to Kafka", ex);
                    return null;
                });
    }

}
