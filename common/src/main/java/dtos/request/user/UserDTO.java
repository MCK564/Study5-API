package dtos.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import validator.image.ImageFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String about;

    @ImageFile
    private MultipartFile avatar;

    @ImageFile
    private MultipartFile banner;

}
