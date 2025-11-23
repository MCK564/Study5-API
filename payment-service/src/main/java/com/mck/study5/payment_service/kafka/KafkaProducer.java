package com.mck.study5.payment_service.kafka;


import com.mck.study5.payment_service.constants.Topics;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishPaymentSuccessMessage(PaymentSuccessMessageEvent event){
        kafkaTemplate.send(Topics.NOTIFICATION_PAYMENT_SUCCESS, event.userId().toString(), event);
    }



}
