package com.mck.study5.upload_service.audio;

import com.mck.study5.upload_service.image.ImageFile;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class AudioFileValidator implements ConstraintValidator<AudioFile, MultipartFile> {
    private static final List<String> AUDIO_CONTENT_TYPES = List.of(
            "audio/mpeg",
            "audio/mp3",
            "audio/wav",
            "audio/x-wav",
            "audio/ogg",
            "audio/webm",
            "audio/aac",
            "audio/flac",
            "audio/x-flac",
            "audio/mp4",
            "audio/x-m4a"
    );
    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context){
        if(file == null || file.isEmpty())return true;
        return AUDIO_CONTENT_TYPES.contains(file.getContentType());
    }

}
