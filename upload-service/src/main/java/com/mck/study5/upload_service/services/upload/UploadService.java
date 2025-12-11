package com.mck.study5.upload_service.services.upload;

import com.mck.study5.upload_service.constants.MessageKeys;
import com.mck.study5.upload_service.dtos.upload.AudioDTO;
import com.mck.study5.upload_service.dtos.upload.UploadDTO;
import com.mck.study5.upload_service.kafka.MediaEventProducer;
import com.mck.study5.upload_service.kafka.events.MediaDeletedEvent;
import com.mck.study5.upload_service.kafka.events.MediaKind;
import com.mck.study5.upload_service.kafka.events.MediaOwnerType;
import com.mck.study5.upload_service.kafka.events.MediaUploadedEvent;
import com.mck.study5.upload_service.kafka.events.MediaUsage;
import com.mck.study5.upload_service.models.Audio;
import com.mck.study5.upload_service.models.BelongToObject;
import com.mck.study5.upload_service.models.Image;
import com.mck.study5.upload_service.repositories.AudioRepository;
import com.mck.study5.upload_service.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UploadService implements IUploadService {

    private final S3Client s3Client;
    private final ImageRepository imageRepository;
    private final MediaEventProducer mediaEventProducer;
    private final AudioRepository audioRepository;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Value("${aws.region}")
    private String region;

    // ========================= IMAGE =========================

    @Override
    public Image uploadImage(UploadDTO dto) {
        MultipartFile file = dto.getFile();
        if (file == null || file.isEmpty()) {
            throw new RuntimeException(MessageKeys.FILE_NOT_FOUND);
        }

        String originalFilename = file.getOriginalFilename();
        String key = "images/" + UUID.randomUUID() + "-" + (originalFilename != null ? originalFilename : "image");

        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .contentType(file.getContentType())
                    .build();

            s3Client.putObject(
                    putObjectRequest,
                    RequestBody.fromInputStream(file.getInputStream(), file.getSize())
            );

        } catch (IOException e) {
            throw new RuntimeException(MessageKeys.UNABLE_UPLOAD_FILE_TO_S3 + e);
        }

        String url = s3Client.utilities()
                .getUrl(builder -> builder.bucket(bucketName).key(key))
                .toExternalForm();

        Image image;


        if (dto.getId() != null) {
            image = imageRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Image not found with id = " + dto.getId()));

            // delete old file on S3
            String oldUrl = image.getUrl();
            String oldKey = extractKeyFromS3Url(oldUrl);

            DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                    .bucket(bucketName)
                    .key(oldKey)
                    .build();

            s3Client.deleteObject(deleteObjectRequest);

            // update info
            image.setUrl(url);
            image.setName(dto.getName() != null ? dto.getName() : originalFilename);
            image.setQuality(dto.getQuality());
            image.setSize(file.getSize());
            image.setBelongToId(dto.getBelongToId());
            image.setBelongToObject(dto.getBelongToObject());
            image.setMediaKind(MediaKind.IMAGE.getKind());
            image.setMediaOwnerType(dto.getMediaOwnerType());
            image.setMediaUsage(dto.getMediaUsage());

        } else {

            image = Image.builder()
                    .name(dto.getName() != null ? dto.getName() : originalFilename)
                    .quality(dto.getQuality())
                    .url(url)
                    .size(file.getSize())
                    .belongToId(dto.getBelongToId())
                    .belongToObject(dto.getBelongToObject())
                    .mediaKind(MediaKind.IMAGE.getKind())
                    .mediaOwnerType(dto.getMediaOwnerType())
                    .mediaUsage(dto.getMediaUsage())
                    .build();
        }

        Image saved = imageRepository.save(image);


        MediaUploadedEvent.MediaUploadedEventBuilder builder = MediaUploadedEvent.builder()
                .ownerId(dto.getBelongToId())
                .imageId(saved.getId())
                .mediaKind(MediaKind.IMAGE.getKind())
                .ownerType(dto.getMediaOwnerType())
                .mediaUsage(MediaUsage.THUMBNAIL.getUsage())
                .url(saved.getUrl());

        String belongToObject = dto.getBelongToObject();

        if (belongToObject != null) {
            if (belongToObject.startsWith("USER_")) {
                builder.ownerType(MediaOwnerType.USER.getType());
                if (BelongToObject.USER_AVATAR.name().equals(belongToObject)) {
                    builder.mediaUsage(MediaUsage.AVATAR.getUsage());
                } else {
                    builder.mediaUsage(MediaUsage.BANNER.getUsage());
                }
            } else if (belongToObject.startsWith("BLOG_")) {
                builder.ownerType(MediaOwnerType.BLOG.getType());
            } else if (belongToObject.startsWith("QUESTION_")) {
                builder.ownerType(MediaOwnerType.QUESTION.getType());
                builder.mediaUsage(MediaUsage.CONTENT.getUsage());
            } else if (belongToObject.startsWith("WORD_")) {
                builder.ownerType(MediaOwnerType.WORD.getType());
                builder.mediaUsage(MediaUsage.CONTENT.getUsage());
            } else if (belongToObject.startsWith("FLASHCARD_")) {
                builder.ownerType(MediaOwnerType.FLASHCARD.getType());
            } else if (belongToObject.startsWith("EXAM_")) {
                builder.ownerType(MediaOwnerType.EXAM.getType());
            } else if(belongToObject.startsWith("COURSE_")){
                builder.ownerType(MediaOwnerType.COURSE.getType());
            }
        }

        mediaEventProducer.publishMediaUploaded(builder.build());

        return saved;
    }

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Image not found with id: " + id + " or it's deleted. Please try again later or contact admin.")
                );
    }

    @Override
    public String deleteImageById(Long id) {
        Image existedImage = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found with id = " + id));

        String oldUrl = existedImage.getUrl();
        String oldKey = extractKeyFromS3Url(oldUrl);

        // delete from S3
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(oldKey)
                .build();

        s3Client.deleteObject(deleteObjectRequest);

        imageRepository.deleteById(id);

        // Build & publish MediaDeletedEvent
        MediaDeletedEvent.MediaDeletedEventBuilder builder = MediaDeletedEvent.builder()
                .ownerId(existedImage.getBelongToId())
                .imageId(id)
                .mediaKind(existedImage.getMediaKind())
                .mediaUsage(MediaUsage.THUMBNAIL.getUsage())
                .url(existedImage.getUrl());

        String belongToObject = existedImage.getBelongToObject().toString();

        if (belongToObject != null) {
            if (belongToObject.startsWith("USER_")) {
                builder.ownerType(MediaOwnerType.USER.getType());
                if (BelongToObject.USER_AVATAR.name().equals(belongToObject)) {
                    builder.mediaUsage(MediaUsage.AVATAR.getUsage());
                } else {
                    builder.mediaUsage(MediaUsage.BANNER.getUsage());
                }
            } else if (belongToObject.startsWith("BLOG_")) {
                builder.ownerType(MediaOwnerType.BLOG.getType());
            } else if (belongToObject.startsWith("QUESTION_")) {
                builder.ownerType(MediaOwnerType.QUESTION.getType());
                builder.mediaUsage(MediaUsage.CONTENT.getUsage());
            } else if (belongToObject.startsWith("WORD_")) {
                builder.ownerType(MediaOwnerType.WORD.getType());
                builder.mediaUsage(MediaUsage.CONTENT.getUsage());
            } else if (belongToObject.startsWith("FLASHCARD_")) {
                builder.ownerType(MediaOwnerType.FLASHCARD.getType());
            } else if (belongToObject.startsWith("EXAM_")) {
                builder.ownerType(MediaOwnerType.EXAM.getType());
            } else if (belongToObject.startsWith("LESSON_")) {
                builder.ownerType(MediaOwnerType.LESSON.getType());
            }

        }

        mediaEventProducer.publishMediaDeleted(builder.build());

        return MessageKeys.DELETE_SUCCESSFULLY + ": image with id = " + id;
    }

    // ========================= AUDIO =========================

    @Override
    public Audio uploadAudio(AudioDTO dto) {
        MultipartFile file = dto.getFile();
        if (file == null || file.isEmpty()) {
            throw new RuntimeException(MessageKeys.FILE_NOT_FOUND);
        }

        String originalFilename = file.getOriginalFilename();
        String key = "audios/" + UUID.randomUUID() + "-" + (originalFilename != null ? originalFilename : "audio");

        byte[] bytes;
        try {
            // ✅ Đọc toàn bộ nội dung file vào byte[]
            bytes = file.getBytes();

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .contentType(file.getContentType())
                    .contentLength((long) bytes.length) // thêm cho chắc cú
                    .build();

            // ✅ Không dùng InputStream nữa, dùng bytes nên không cần mark/reset
            s3Client.putObject(
                    putObjectRequest,
                    RequestBody.fromBytes(bytes)
            );

        } catch (IOException e) {
            throw new RuntimeException(MessageKeys.UNABLE_UPLOAD_FILE_TO_S3 + e);
        }

        String url = s3Client.utilities()
                .getUrl(builder -> builder.bucket(bucketName).key(key))
                .toExternalForm();

        Audio audio;
        if (dto.getId() != null) {
            audio = audioRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Audio not found with id = " + dto.getId()));

            // delete old file on S3
            String oldUrl = audio.getUrl();
            String oldKey = extractKeyFromS3Url(oldUrl);

            DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                    .bucket(bucketName)
                    .key(oldKey)
                    .build();

            s3Client.deleteObject(deleteObjectRequest);

            audio.setUrl(url);
            audio.setName(dto.getName() != null ? dto.getName() : originalFilename);

            audio.setSize((long) bytes.length);
            audio.setBelongToId(dto.getBelongToId());
            audio.setBelongToObject(dto.getBelongToObject());
            audio.setMediaKind(MediaKind.AUDIO.getKind());

        } else {
            audio = Audio.builder()
                    .name(dto.getName() != null ? dto.getName() : originalFilename)
                    .url(url)
                    .size((long) bytes.length)
                    .belongToId(dto.getBelongToId())
                    .belongToObject(dto.getBelongToObject())
                    .mediaKind(MediaKind.AUDIO.getKind())
                    .build();
        }

        Audio saved = audioRepository.save(audio);

        // Up event cho AUDIO
        MediaUploadedEvent.MediaUploadedEventBuilder builder = MediaUploadedEvent.builder()
                .ownerId(dto.getBelongToId())
                .imageId(saved.getId()) // nếu event dùng field "imageId" chung cho mọi media thì OK
                .mediaKind(MediaKind.AUDIO.getKind())
                .mediaUsage(MediaUsage.CONTENT.getUsage())
                .url(saved.getUrl());

        String belongToObject = dto.getBelongToObject();

        if (belongToObject != null) {
            if (belongToObject.startsWith("QUESTION_")) {
                builder.ownerType(MediaOwnerType.QUESTION.getType());
            } else if (belongToObject.startsWith("WORD_")) {
                builder.ownerType(MediaOwnerType.WORD.getType());
            } else if (belongToObject.startsWith("EXAM_")) {
                builder.ownerType(MediaOwnerType.EXAM.getType());
            } else if (belongToObject.startsWith("FLASHCARD_")) {
                builder.ownerType(MediaOwnerType.FLASHCARD.getType());
            } else if (belongToObject.startsWith("EXAM_")) {
                builder.ownerType(MediaOwnerType.EXAM.getType());
            } else if (belongToObject.startsWith("LESSON_")) {
                builder.ownerType(MediaOwnerType.LESSON.getType());
            }

        }

        mediaEventProducer.publishMediaUploaded(builder.build());

        return saved;
    }


    @Override
    public Audio getAudioById(Long id) {
        return audioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Audio not found with id = " + id));
    }

    @Override
    public String deleteAudioById(Long id) {
        Audio existedAudio = audioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Audio not found with id = " + id));

        String oldUrl = existedAudio.getUrl();
        String oldKey = extractKeyFromS3Url(oldUrl);

        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(oldKey)
                .build();

        s3Client.deleteObject(deleteObjectRequest);
        audioRepository.deleteById(id);

        MediaDeletedEvent.MediaDeletedEventBuilder builder = MediaDeletedEvent.builder()
                .ownerId(existedAudio.getBelongToId())
                .imageId(id) // nếu event có mediaId thì đổi lại
                .mediaKind(existedAudio.getMediaKind())
                .mediaUsage(MediaUsage.CONTENT.getUsage())
                .url(existedAudio.getUrl());

        String belongToObject = existedAudio.getBelongToObject().toString();

        if (belongToObject != null) {
            if (belongToObject.startsWith("QUESTION_")) {
                builder.ownerType(MediaOwnerType.QUESTION.getType());
            } else if (belongToObject.startsWith("WORD_")) {
                builder.ownerType(MediaOwnerType.WORD.getType());
            } else if (belongToObject.startsWith("EXAM_")) {
                builder.ownerType(MediaOwnerType.EXAM.getType());
            } else if (belongToObject.startsWith("FLASHCARD_")) {
                builder.ownerType(MediaOwnerType.FLASHCARD.getType());
            }
        }

        mediaEventProducer.publishMediaDeleted(builder.build());

        return MessageKeys.DELETE_SUCCESSFULLY + ": audio with id =" + id;
    }

    // ========================= HELPER =========================

    private String extractKeyFromS3Url(String url) {
        try {
            URI uri = URI.create(url);
            String path = uri.getPath();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            return path;
        } catch (Exception e) {
            throw new RuntimeException("Invalid S3 URL: " + url, e);
        }
    }
}
