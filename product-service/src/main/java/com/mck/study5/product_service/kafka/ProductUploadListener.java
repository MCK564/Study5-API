package com.mck.study5.product_service.kafka;


import com.mck.study5.product_service.constants.Topics;

import com.mck.study5.product_service.kafka.events.MediaUploadedEvent;
import com.mck.study5.product_service.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductUploadListener {
    private final WordRepository   wordRepository;
    private final FlashCardRepository flashCardRepository;
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final BlogRepository blogRepository;


    @KafkaListener(
            topics = Topics.MEDIA_UPLOADED,
            groupId = "product-service",
            containerFactory = "mediaUploadedKafkaListenerContainerFactory"
    )
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

            case "BLOG" -> {
                blogRepository.findById(event.ownerId())
                        .ifPresent(blog ->{
                            blog.setThumbnail(event.url());
                            blog.setThumbnailId(event.imageId());
                            blogRepository.save(blog);
                            log.info("Updated BLOG image: blogId={}, url={}", event.ownerId(), event.url());
                        });
            }
            case "WORD" -> {
                wordRepository.findById(event.ownerId())
                        .ifPresent(word-> {
                            word.setImageId(event.imageId());
                            word.setImageUrl(event.url());
                            wordRepository.save(word);
                            log.info("Updated WORD image: wordId={}, url={}", event.ownerId(), event.url());
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
                                word.setAudio(event.url());
                                word.setAudioId(event.imageId());
                                wordRepository.save(word);
                                log.info("Updated WORD audio: wordId={}, url={}", event.ownerId(), event.url());
                            }
                    );
        }
        else if( ownerType.equals("LESSON") ){
            lessonRepository.findById(event.ownerId())
                    .ifPresent(lesson -> {
                        lesson.setThumbnail(event.url());
                        lesson.setThumbnailId(event.imageId());
                        lessonRepository.save(lesson);
                        log.info("Updated LESSON audio: lessonId={}, url={}", event.ownerId(), event.url());
                    });
        }


    }

    @KafkaListener(
            topics = Topics.MEDIA_DELETED,
            groupId = "product-service",
            containerFactory = "mediaDeletedEventKafkaListenerContainerFactory"
    )
    public void handleProductDeleted(MediaUploadedEvent event){
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


}
