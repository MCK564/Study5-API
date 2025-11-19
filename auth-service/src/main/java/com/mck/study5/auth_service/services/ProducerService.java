package com.mck.study5.auth_service.services;


import com.mck.study5.auth_service.kafka.events.UserInfoCreateEvent;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, UserInfoCreateEvent> kafkaTemplate;

    @Value("${app.kafka.topics.user-social-signup}")
    private String topic;

    public void publish(UserInfoCreateEvent event){
        kafkaTemplate.send(topic, event);
    }
}
