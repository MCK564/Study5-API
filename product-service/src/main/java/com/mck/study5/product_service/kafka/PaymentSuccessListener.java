package com.mck.study5.product_service.kafka;


import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.constants.Topics;
import com.mck.study5.product_service.exceptions.DataNotFoundException;
import com.mck.study5.product_service.kafka.events.PaymentSuccessMessageEvent;
import com.mck.study5.product_service.models.Course;
import com.mck.study5.product_service.models.CourseEnrollment;
import com.mck.study5.product_service.repositories.CourseEnrollmentRepository;
import com.mck.study5.product_service.repositories.CourseRepository;
import com.mck.study5.product_service.services.courses.CourseService;
import com.mck.study5.product_service.services.courses.ICourseService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentSuccessListener {
    private final CourseEnrollmentRepository courseEnrollmentRepository;
    private final CourseRepository courseRepository;
    private final ICourseService courseService;


    @KafkaListener(
            topics = Topics.NOTIFICATION_PAYMENT_SUCCESS,
            groupId = "product-service",
            containerFactory = "sendingMessageKafkaListenerContainerFactory"
    )
    public void handlePaymentSuccessMessage(PaymentSuccessMessageEvent event) {
        log.info("Sending payment success message event received: {}", event);

        if (event == null) {
            log.warn("Sending message event not found: {}", event);
            return;
        }

        Course existedCourse = courseRepository.findById(event.courseId()).orElseThrow(()->new
                DataNotFoundException(MessageKeys.DATA_NOT_FOUND+": course with id="+event.paymentId()));
        CourseEnrollment newCourseEnrollment = CourseEnrollment.builder()
                .paymentId(event.paymentId())
                .course(existedCourse)
                .LessonCompleted(0)
                .expireAt(LocalDateTime.now().plusMonths(12))
                .userId(event.userId())
                .build();

        courseEnrollmentRepository.save(newCourseEnrollment);
        courseService.evictUnlockCourseCache(event.userId());
        log.info("Saved new course enrollment: {}", newCourseEnrollment);
    }
}
