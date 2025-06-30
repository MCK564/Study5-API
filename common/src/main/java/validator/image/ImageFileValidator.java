package validator.image;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ImageFileValidator implements ConstraintValidator<ImageFile, MultipartFile> {
    private static final List<String> IMAGE_CONTENT_TYPES = List.of("image/jpeg", "image/png","image/gif","image/webp");

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context){
        if(file == null || file.isEmpty())return true;
        return IMAGE_CONTENT_TYPES.contains(file.getContentType());
    }

}
