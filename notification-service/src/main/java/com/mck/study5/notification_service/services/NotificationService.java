package com.mck.study5.notification_service.services;

import com.mck.study5.notification_service.dto.MailDTO;
import com.mck.study5.notification_service.models.Notification;
import com.mck.study5.notification_service.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NotificationService implements INotificationService{
    private final NotificationRepository notiRepository;
    private final MailService mailService;

    @Override
    public List<Notification> findAllByUserIdTo(Long userIdTo) {
        return  notiRepository.findAllByUserIdTo(userIdTo);
    }

    @Override
    public Boolean markNotificationAsRead(String id) {
        Notification existingNoti =  notiRepository.findById(id).orElse(null);
        if(existingNoti!=null){
            existingNoti.setStatus(1L);
            notiRepository.save(existingNoti);
            return true;
        }
        return false;
    }

    @Override
    public Boolean sendMail(MailDTO mailDTO) throws Exception {
        if(!((mailDTO.getToEmail() == null) && mailDTO.getToEmail().equals(""))){
            mailService.sendHtmlEmail(mailDTO.getToEmail(), mailDTO.getSubject(), mailDTO.getBody());
            return true;
        }
        return false;
    }

    @Override

    public void deleteNotification(String id) {
        if(notiRepository.existsById(id)){
            notiRepository.deleteById(id);
        }

    }

    @Override
    public void deleteAllNotification(Long userIdTo) {
        notiRepository.deleteAllByUserIdTo(userIdTo);
    }
}
