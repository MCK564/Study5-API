package feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "notification-service", path = "${api.prefix}/notifications")
public class NotificationClient {
//    feign for admin triggers manual announcement or password reset email
//    kafka/rabbitMQ usually for notifying users after submitting a test or for logging and analytics.

}
