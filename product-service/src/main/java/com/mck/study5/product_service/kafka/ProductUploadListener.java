package com.mck.study5.product_service.kafka;


import com.mck.study5.product_service.constants.Topics;

import com.mck.study5.product_service.kafka.events.MediaUploadedEvent;
import com.mck.study5.product_service.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@ComponentScan
@RequiredArgsConstructor
public class ProductUploadListener {
    private final WordRepository   wordRepository;
    private final FlashCardRepository flashCardRepository;
    private final CourseRepository courseRepository;

    @KafkaListener(topics = Topics.MEDIA_UPLOADED, groupId = "product-service")
    public void handleProductUploaded(MediaUploadedEvent event){
        log.info("Product uploaded message received: {}", event);

        if (event == null || event.ownerType() == null || event.mediaKind() == null) {
            log.warn("MediaUploadedEvent not valid: {}", event);
            return;
        }

        switch (event.mediaKind()) {
            case "IMAGE" -> handleImageUploaded(event);
            case "AUDIO" -> handleAudioUploaded(event);
            default -> log.warn("Unsupported mediaKind: {}", event.mediaKind());
        }
    }


    private void handleImageUploaded(MediaUploadedEvent event) {
        String ownerType = event.ownerType();
        switch (ownerType) {

            case "FLASHCARD" -> {
                flashCardRepository.findById(event.ownerId())
                        .ifPresent(flashcard -> {
                            flashcard.setThumbnailUrl(event.url());
                            flashcard.setThumbnailId(event.imageId());
                            flashCardRepository.save(flashcard);
                            log.info("Updated FLASHCARD image: flashcardId={}, url={}", event.ownerId(), event.url());
                        });
            }



            case "COURSE" -> {
                courseRepository.findById(event.ownerId())
                        .ifPresent(course -> {
                            course.setThumbnailUrl(event.url());
                            course.setThumbnailId(event.imageId());
                            courseRepository.save(course);
                            log.info("Updated COURSE image: courseId={}, url={}", event.ownerId(), event.url());
                        });
            }

            default -> log.info("Image uploaded for unsupported ownerType: {}", ownerType);
        }
    }


    private void handleAudioUploaded(MediaUploadedEvent event) {
        String ownerType = event.ownerType();
        if (ownerType.equals("WORD")) {
            wordRepository.findById(event.ownerId())
                    .ifPresent(word -> {
                                word.setAudioLink(event.url());
                                word.setAudioId(event.imageId());
                                wordRepository.save(word);
                                log.info("Updated WORD audio: wordId={}, url={}", event.ownerId(), event.url());
                            }
                    );
        }
    }
}
