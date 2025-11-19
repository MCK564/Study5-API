package com.mck.study5.upload_service.config;

import com.mck.study5.upload_service.constants.Topics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic userAvatarOrBannerUploadedTopic(){
        return TopicBuilder.name(Topics.USER_AVATAR_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic productBlogImageUploadedTopic(){
        return TopicBuilder.name(Topics.PRODUCT_BLOG_IMAGE_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic productExamImageUploadedTopic(){
        return TopicBuilder.name(Topics.PRODUCT_EXAM_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic productQuestionImageUploadedTopic(){
        return TopicBuilder.name(Topics.PRODUCT_QUESTION_IMAGE_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic productFlashCardImageUploadEvent(){
        return TopicBuilder.name(Topics.PRODUCT_FLASHCARD_IMAGE_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic productWordImageAndAudioUploadEvent(){
        return TopicBuilder.name(Topics.PRODUCT_WORD_IMAGE_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic productQuestionAudioUploadedTopic(){
        return TopicBuilder.name(Topics.PRODUCT_QUESTION_AUDIO_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic productWordAudioUploadedTopic(){
        return TopicBuilder.name(Topics.PRODUCT_WORD_AUDIO_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic productCourseImageUploadTopic(){
        return TopicBuilder.name(Topics.PRODUCT_COURSE_IMAGE_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic productLessonAvatarUploadTopic(){
        return TopicBuilder.name(Topics.PRODUCT_LESSON_AVATAR_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic productLessonVideoUploadTopic(){
        return TopicBuilder.name(Topics.PRODUCT_LESSON_VIDEO_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic mediaUploadedTopic(){
        return TopicBuilder.name(Topics.MEDIA_UPLOADED)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic mediaDeletedTopic(){
        return TopicBuilder.name(Topics.MEDIA_DELETED)
                .partitions(3)
                .replicas(1)
                .build();
    }


}
