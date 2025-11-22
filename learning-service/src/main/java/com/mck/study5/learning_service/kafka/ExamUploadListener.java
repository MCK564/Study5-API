package com.mck.study5.learning_service.kafka;


import com.mck.study5.learning_service.constants.Topics;
import com.mck.study5.learning_service.kafka.events.MediaUploadedEvent;
import com.mck.study5.learning_service.repository.ExamRepository;
import com.mck.study5.learning_service.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@ComponentScan
@RequiredArgsConstructor
public class ExamUploadListener {
    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;


    @KafkaListener(
            topics = Topics.MEDIA_UPLOADED,
            groupId = "learning-service",
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
            case "QUESTION" -> {
                questionRepository.findById(event.ownerId())
                        .ifPresent(question -> {
                            question.setImageUrl(event.url());
                            question.setImageId(event.imageId());
                            questionRepository.save(question);
                            log.info("Updated QUESTION image: questionId={}, url={}", event.ownerId(), event.url());
                        });
            }


            case "EXAM" -> {
                examRepository.findById(event.ownerId())
                        .ifPresent(exam -> {
                            exam.setThumbnailUrl(event.url());
                            exam.setThumbnailId(event.imageId());
                            examRepository.save(exam);
                            log.info("Updated EXAM image: examId={}, url={}", event.ownerId(), event.url());
                        });
            }
            default -> log.info("Image uploaded for unsupported ownerType: {}", ownerType);
        }
    }


    private void handleAudioUploaded(MediaUploadedEvent event) {
        String ownerType = event.ownerType();
        switch (ownerType) {
            case "QUESTION" -> {
                questionRepository.findById(event.ownerId())
                        .ifPresent(question-> {
                            question.setAudio(event.url());
                            question.setAudioId(event.imageId());
                            questionRepository.save(question);
                            log.info("Updated QUESTION audio: questionId={}, url={}", event.ownerId(), event.url());
                        });
            }
        }
    }
}
