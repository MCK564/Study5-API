package com.mck.study5.notification_service.services;

import com.mck.study5.notification_service.dto.MailDTO;
import com.mck.study5.notification_service.models.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface INotificationService {
    List<Notification> findAllByUserIdTo (Long userIdTo);
    Boolean markNotificationAsRead (String id);
    Boolean sendMail(MailDTO mailDTO) throws Exception;
    void deleteNotification(String id);
    void deleteAllNotification(Long userIdTo);


}
