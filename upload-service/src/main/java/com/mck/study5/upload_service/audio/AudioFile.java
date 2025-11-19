package com.mck.study5.upload_service.audio;


import com.mck.study5.upload_service.image.ImageFileValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AudioFileValidator.class)
public @interface AudioFile {
    String message() default "File must be an audio";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
