package com.mck.study5.payment_service.kafka;


import com.mck.study5.payment_service.constants.Topics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@ComponentScan

@Configuration
public class KafkaTopicsConfig {

    @Bean
    public NewTopic paymentSuccessNotificationEvent(){
        return TopicBuilder.name(Topics.NOTIFICATION_PAYMENT_SUCCESS)
                .partitions(3)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic paymentSuccessUpdateCourseEnrollment(){
        return TopicBuilder.name(Topics.PAYMENT_SUCCESS_SO_UPDATE_COURSE_ENROLLMENT)
                .partitions(3)
                .replicas(1)
                .build();
    }


}
