package com.mck.study5.notification_service.models;


import com.mck.study5.notification_service.enums.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="notification")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Notification {
    @Id
    private String id;
    private String title;
    private String body;
    private Long userIdTo;
    private Long userIdFrom;
    private NotificationType notificationType;
    private Long status = 0L;
}
