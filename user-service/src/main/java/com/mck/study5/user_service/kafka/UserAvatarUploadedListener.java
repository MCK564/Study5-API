package com.mck.study5.user_service.kafka;


import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.constants.Topics;
import com.mck.study5.user_service.kafka.events.MediaOwnerType;
import com.mck.study5.user_service.kafka.events.MediaUploadedEvent;
import com.mck.study5.user_service.kafka.events.MediaUsage;
import com.mck.study5.user_service.kafka.events.UserInfoCreateEvent;
import com.mck.study5.user_service.models.User;
import com.mck.study5.user_service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class UserAvatarUploadedListener {
    private final UserRepository userRepository;

    @KafkaListener(
            topics = Topics.MEDIA_UPLOADED,
            groupId = "user-service",
            containerFactory = "mediaUploadedKafkaListenerContainerFactory"
    )
    public void handleAvatar(MediaUploadedEvent event){
        log.info("Received UserAvatarUploadedEvent: {}", event.toString());
        var user = userRepository.findById(event.ownerId())
                .orElseThrow(()-> new RuntimeException(MessageKeys.DATA_NOT_FOUND+": user with id = "+event.ownerId()));

            log.info(event.imageId().toString());
        if (event.ownerType().equals(MediaOwnerType.USER.getType())){
            if( event.mediaUsage().equals(MediaUsage.AVATAR.getUsage())) {
                user.setAvatarId(event.imageId());
                user.setAvatar(event.url());
            }
            else if(event.mediaUsage().equals(MediaUsage.BANNER.getUsage())){
                user.setBannerId(event.imageId());
                user.setBanner(event.url());
            }
        }

         userRepository.save(user);
         log.info("Updated user avatar successfully: {}", user);
    }



    @KafkaListener(
            topics = Topics.USER_CREATED,
            groupId = "user-service",
            containerFactory = "userCreatedKafkaListenerContainerFactory"
    )
    public void handleUserCreated(UserInfoCreateEvent event) {
        log.info("Received UserInfoCreateEvent: {}", event);

        User newUser = User.builder()
                .id(event.id())
                .name(event.name())
                .email(event.email())
                .avatar(event.picture())
                .status(true)
                .build();

        userRepository.save(newUser);
        log.info("Created user successfully: {}", newUser);
    }

    @KafkaListener(topics = Topics.MEDIA_DELETED, groupId = "user-service")
    public void handleMediaDeleted(MediaUploadedEvent event){
        log.info("Received MediaUploadedEvent: {}", event.toString());
        var user = userRepository.findById(event.ownerId())
                .orElseThrow(()-> new RuntimeException(MessageKeys.DATA_NOT_FOUND+": user with id = "+event.ownerId()));

        if (event.ownerType().equals(MediaOwnerType.USER.getType())){
            if( event.mediaUsage().equals(MediaUsage.AVATAR.getUsage())) {
                user.setAvatarId(null);
                user.setAvatar(null);
            }
            else if(event.mediaUsage().equals(MediaUsage.BANNER.getUsage())){
                user.setBannerId(null);
                user.setBanner(null);
            }
        }
        userRepository.save(user);
        log.info("Deleted avatar/banner: {}", user.toString());
    }
}
