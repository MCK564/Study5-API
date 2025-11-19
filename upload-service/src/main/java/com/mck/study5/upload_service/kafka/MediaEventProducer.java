package com.mck.study5.upload_service.kafka;


import com.mck.study5.upload_service.constants.Topics;
import com.mck.study5.upload_service.kafka.events.*;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaEventProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishMediaUploaded(MediaUploadedEvent event){
        kafkaTemplate.send(Topics.MEDIA_UPLOADED, event.ownerId().toString(), event);
    }

    public void publishMediaDeleted(MediaDeletedEvent event){
        kafkaTemplate.send(Topics.MEDIA_DELETED , event.ownerId().toString(), event);
    }

}
