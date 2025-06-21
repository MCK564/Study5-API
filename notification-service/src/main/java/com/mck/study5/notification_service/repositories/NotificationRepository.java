package com.mck.study5.notification_service.repositories;

import com.mck.study5.notification_service.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,String> {
    List<Notification> findAllByUserIdTo (Long userIdTo);
    Optional<Notification>  findByUserIdTo(Long userIdTo);
    void deleteAllByUserIdTo (Long userIdTo);
}
