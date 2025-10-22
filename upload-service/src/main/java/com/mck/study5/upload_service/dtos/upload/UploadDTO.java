package com.mck.study5.upload_service.dtos.upload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.upload_service.image.ImageFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadDTO {
    private Long id;
    private String name;
    private String quality;
    private Byte size;
    private String url;
    private String description;

    @ImageFile
    private MultipartFile file;
    @JsonProperty("belong_to_id")
    private Long belongToId;

    @JsonProperty("belong_to_object")
    private String belongToObject; // avatar, thumbnail,
}
